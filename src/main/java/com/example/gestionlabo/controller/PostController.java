package com.example.gestionlabo.controller;

import com.example.gestionlabo.model.Post;
import com.example.gestionlabo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable String id) {
        return postService.findById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.save(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post updatedPost) {
        return postService.update(id, updatedPost);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable String id) {
        postService.deleteById(id);
    }
}
