package com.tamerm.blog_app.service;

import com.tamerm.blog_app.model.Post;

public interface PostService {
    Post createPost(Post post);
    void logPostCount();
}
