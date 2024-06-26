package com.example.gestionlabo.service;

import com.example.gestionlabo.model.Post;
import com.example.gestionlabo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found with id " + id));
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Post update(String id, Post updatedPost) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id " + id));

        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setDate(updatedPost.getDate());
        existingPost.setContent(updatedPost.getContent());

        return postRepository.save(existingPost);
    }

    public void deleteById(String id) {
        postRepository.deleteById(id);
    }
}
