package com.tamerm.blog_app.unit.service;

import com.tamerm.blog_app.model.Post;
import com.tamerm.blog_app.service.impl.PostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Unit tests for PostServiceImpl.
 */
class PostServiceTest {

    @Mock
    private List<Post> posts;

    @InjectMocks
    private PostServiceImpl postService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPost_ShouldAddPostToList() {
        Post post = new Post();
        post.setTitle("Test Title");
        post.setText("Test Text");

        Post result = postService.createPost(post);

        verify(posts, times(1)).add(post);
        assertEquals(post, result);
    }

    @Test
    void logPostCount_ShouldLogPostCount() {
        when(posts.size()).thenReturn(5);

        postService.logPostCount();

        verify(posts, times(1)).size();
    }
}