package com.example.gestionlabo.repository;

import com.example.gestionlabo.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
