package com.example.gestionlabo.repository;

import com.example.gestionlabo.model.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommandeRepository extends MongoRepository<Commande, String> {
}
