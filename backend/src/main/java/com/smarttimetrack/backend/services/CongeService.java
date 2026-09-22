package com.smarttimetrack.backend.services;

import com.smarttimetrack.backend.models.Conge;
import com.smarttimetrack.backend.models.CongeStatus;
import com.smarttimetrack.backend.repository.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CongeService {

    @Autowired
    private CongeRepository congeRepository;

    public Conge validerDemande(String congeId, boolean accepter, String commentaireAdmin) {
        Optional<Conge> congeOpt = congeRepository.findById(congeId);
        if (congeOpt.isEmpty()) {
            throw new RuntimeException("Demande de congé introuvable avec l'ID: " + congeId);
        }
        
        Conge conge = congeOpt.get();
        if (conge.getStatus() != CongeStatus.EN_ATTENTE) {
            throw new IllegalStateException("Ce congé a déjà été traité.");
        }

        conge.setStatus(accepter ? CongeStatus.ACCEPTE : CongeStatus.REFUSE);
        conge.setCommentaireAdmin(commentaireAdmin);

        return congeRepository.save(conge);
    }
}
