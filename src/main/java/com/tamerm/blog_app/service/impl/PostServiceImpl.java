package com.tamerm.blog_app.service.impl;

import com.tamerm.blog_app.model.Post;
import com.tamerm.blog_app.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final List<Post> posts;

    public PostServiceImpl(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public Post createPost(Post post) {
        posts.add(post);
        log.info("Post created with title: {}", post.getTitle());
        return post;
    }

    @Override
    public void logPostCount() {
        log.info("Total number of posts: {}", posts.size());
    }
}
