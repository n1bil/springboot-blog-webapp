package com.example.springbootblogwebapp.service;

import com.example.springbootblogwebapp.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAllPosts();

    void createPost(PostDto postDto);

    PostDto findPostById(Long postId);

    void updatePost(PostDto postDto);

    void deletePost(Long postId);

    PostDto findPostByUrl(String postUrl);
}
