package com.example.gestionlabo.repository;



import com.example.gestionlabo.model.Labo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LaboRepository extends MongoRepository<Labo, String> {
}
