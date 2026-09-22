package com.smarttimetrack.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.LocalTime;

@Document(collection = "pointages")
public class Pointage {
    @Id
    private String id;
    private String userId;
    private LocalDate date;
    private LocalTime heure;
    private double latitude;
    private double longitude;
    private PointageType type;
    private boolean valide;

    public Pointage() {}

    public Pointage(String userId, LocalDate date, LocalTime heure, double latitude, double longitude, PointageType type, boolean valide) {
        this.userId = userId;
        this.date = date;
        this.heure = heure;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.valide = valide;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public LocalTime getHeure() { return heure; }
    public void setHeure(LocalTime heure) { this.heure = heure; }
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public PointageType getType() { return type; }
    public void setType(PointageType type) { this.type = type; }
    public boolean isValide() { return valide; }
    public void setValide(boolean valide) { this.valide = valide; }
}
