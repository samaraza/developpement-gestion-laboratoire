package com.example.gestionlabo.repository;

import com.example.gestionlabo.model.Tp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TpRepository extends MongoRepository<Tp, String> {
}
