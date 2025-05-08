package com.tamerm.blog_app.controller;

import com.tamerm.blog_app.model.Post;
import com.tamerm.blog_app.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping()
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post);
        return ResponseEntity.status(201).body(createdPost);
    }

    @GetMapping("/log-count")
    public ResponseEntity<Void> logPostCount() {
        postService.logPostCount();
        return ResponseEntity.ok().build();
    }
}
