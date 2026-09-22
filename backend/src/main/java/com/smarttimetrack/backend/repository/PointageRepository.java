package com.smarttimetrack.backend.repository;

import com.smarttimetrack.backend.models.Pointage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PointageRepository extends MongoRepository<Pointage, String> {
    List<Pointage> findByUserId(String userId);
    List<Pointage> findByUserIdAndDate(String userId, LocalDate date);
}
