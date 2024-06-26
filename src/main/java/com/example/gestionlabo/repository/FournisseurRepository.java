package com.example.gestionlabo.repository;

import com.example.gestionlabo.model.Fournisseur;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FournisseurRepository extends MongoRepository<Fournisseur, String> {
}
