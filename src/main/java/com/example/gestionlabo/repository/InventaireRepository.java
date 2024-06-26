package com.example.gestionlabo.repository;

import com.example.gestionlabo.model.Inventaire;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventaireRepository extends MongoRepository<Inventaire, String> {
}
