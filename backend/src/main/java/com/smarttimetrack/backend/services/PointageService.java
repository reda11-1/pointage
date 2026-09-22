package com.smarttimetrack.backend.services;

import com.smarttimetrack.backend.dto.PointageRequest;
import com.smarttimetrack.backend.models.Pointage;
import com.smarttimetrack.backend.repository.PointageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class PointageService {

    @Autowired
    private PointageRepository pointageRepository;

    @Value("${app.company.latitude:48.8566}")
    private double companyLatitude;

    @Value("${app.company.longitude:2.3522}")
    private double companyLongitude;

    @Value("${app.company.allowedRadius:50}")
    private double allowedRadiusInMeters;

    @Value("${app.qrcode.dailySecret:SECRET_QR_CODE_123}")
    private String expectedQrCodeToken;

    public Pointage enregistrerPointage(PointageRequest request) {
        boolean isQrCodeValid = validateQrCode(request.getQrCodeToken());
        boolean isGpsValid = isLocationValid(request.getLatitude(), request.getLongitude());
        boolean isValide = isQrCodeValid && isGpsValid;

        Pointage pointage = new Pointage(
                request.getUserId(),
                LocalDate.now(),
                LocalTime.now(),
                request.getLatitude(),
                request.getLongitude(),
                request.getType(),
                isValide
        );

        return pointageRepository.save(pointage);
    }

    private boolean validateQrCode(String scannedToken) {
        if (scannedToken == null || scannedToken.isEmpty()) return false;
        return scannedToken.equals(expectedQrCodeToken);
    }

    private boolean isLocationValid(double lat, double lon) {
        final int R = 6371; 
        double latDistance = Math.toRadians(companyLatitude - lat);
        double lonDistance = Math.toRadians(companyLongitude - lon);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(companyLatitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distanceInMeters = R * c * 1000;
        return distanceInMeters <= allowedRadiusInMeters;
    }
}
