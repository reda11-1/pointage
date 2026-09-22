package com.smarttimetrack.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "conges")
public class Conge {
    @Id
    private String id;
    private String userId;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private CongeType type;
    private CongeStatus status;
    private String motif;
    private String commentaireAdmin;
    private LocalDateTime dateDemande;

    public Conge() {
        this.dateDemande = LocalDateTime.now();
        this.status = CongeStatus.EN_ATTENTE;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }
    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
    public CongeType getType() { return type; }
    public void setType(CongeType type) { this.type = type; }
    public CongeStatus getStatus() { return status; }
    public void setStatus(CongeStatus status) { this.status = status; }
    public String getMotif() { return motif; }
    public void setMotif(String motif) { this.motif = motif; }
    public String getCommentaireAdmin() { return commentaireAdmin; }
    public void setCommentaireAdmin(String commentaireAdmin) { this.commentaireAdmin = commentaireAdmin; }
    public LocalDateTime getDateDemande() { return dateDemande; }
    public void setDateDemande(LocalDateTime dateDemande) { this.dateDemande = dateDemande; }
}
