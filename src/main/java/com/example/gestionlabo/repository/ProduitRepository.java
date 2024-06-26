package com.example.gestionlabo.repository;

import com.example.gestionlabo.model.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProduitRepository extends MongoRepository<Produit, String> {
}
