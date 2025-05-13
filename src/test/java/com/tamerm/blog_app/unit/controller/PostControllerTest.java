package com.tamerm.blog_app.unit.controller;

import com.tamerm.blog_app.controller.PostController;
import com.tamerm.blog_app.model.Post;
import com.tamerm.blog_app.service.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PostController.class)
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    void createPost_ShouldReturnCreatedPost() throws Exception {
        Post post = new Post();
        post.setTitle("Test Title");
        post.setText("Test Text");

        when(postService.createPost(any(Post.class))).thenReturn(post);

        mockMvc.perform(post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Test Title\",\"text\":\"Test Text\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Test Title"))
                .andExpect(jsonPath("$.text").value("Test Text"));

        verify(postService, times(1)).createPost(any(Post.class));
    }

    @Test
    void logPostCount_ShouldReturnOk() throws Exception {
        mockMvc.perform(get("/api/posts/log-count"))
                .andExpect(status().isOk());

        verify(postService, times(1)).logPostCount();
    }
}