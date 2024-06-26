package com.example.gestionlabo.repository;

import com.example.gestionlabo.model.Preparation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PreparationRepository extends MongoRepository<Preparation, String> {
}
