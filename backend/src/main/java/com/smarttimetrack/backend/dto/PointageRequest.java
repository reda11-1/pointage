package com.smarttimetrack.backend.dto;

import com.smarttimetrack.backend.models.PointageType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PointageRequest {
    @NotBlank
    private String userId;
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
    @NotBlank
    private String qrCodeToken;
    @NotNull
    private PointageType type;

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public String getQrCodeToken() { return qrCodeToken; }
    public void setQrCodeToken(String qrCodeToken) { this.qrCodeToken = qrCodeToken; }
    public PointageType getType() { return type; }
    public void setType(PointageType type) { this.type = type; }
}
