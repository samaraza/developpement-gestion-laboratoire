package com.example.gestionlabo.repository;

import com.example.gestionlabo.model.Armoire;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArmoireRepository extends MongoRepository<Armoire, String> {
}
