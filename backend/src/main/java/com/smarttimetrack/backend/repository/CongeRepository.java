package com.smarttimetrack.backend.repository;

import com.smarttimetrack.backend.models.Conge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CongeRepository extends MongoRepository<Conge, String> {
    List<Conge> findByUserIdOrderByDateDemandeDesc(String userId);
    List<Conge> findByStatusOrderByDateDemandeAsc(String status);
}
