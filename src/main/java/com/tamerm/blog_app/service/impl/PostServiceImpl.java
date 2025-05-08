package com.tamerm.blog_app.service.impl;

import com.tamerm.blog_app.model.Post;
import com.tamerm.blog_app.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final List<Post> posts = new ArrayList<>();

    @Override
    public Post createPost(Post post) {
        posts.add(post);
        return post;
    }

    @Override
    public void logPostCount() {
        System.out.println("Total number of posts: " + posts.size());
    }
}
