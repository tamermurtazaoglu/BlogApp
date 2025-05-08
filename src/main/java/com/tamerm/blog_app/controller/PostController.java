package com.tamerm.blog_app.controller;

import com.tamerm.blog_app.model.Post;
import com.tamerm.blog_app.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping(consumes = "application/json", produces = "application/json")
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
