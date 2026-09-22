package com.smarttimetrack.backend.controllers;

import com.smarttimetrack.backend.dto.PointageRequest;
import com.smarttimetrack.backend.models.Pointage;
import com.smarttimetrack.backend.services.PointageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pointage")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PointageController {

    @Autowired
    private PointageService pointageService;

    @PostMapping("/enregistrer")
    public ResponseEntity<?> createPointage(@Valid @RequestBody PointageRequest request) {
        try {
            Pointage pointage = pointageService.enregistrerPointage(request);
            if(pointage.isValide()) {
                return ResponseEntity.ok(pointage);
            } else {
                return ResponseEntity.status(400).body("Pointage enregistré mais marqué comme INVALIDE. Motif: Hors de la zone autorisée ou QR Code incorrect.");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors du pointage: " + e.getMessage());
        }
    }
}
