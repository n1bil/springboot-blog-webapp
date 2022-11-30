package com.example.springbootblogwebapp.service.impl;

import com.example.springbootblogwebapp.dto.PostDto;
import com.example.springbootblogwebapp.entity.Post;
import com.example.springbootblogwebapp.mapper.PostMapper;
import com.example.springbootblogwebapp.repository.PostRepository;
import com.example.springbootblogwebapp.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public List<PostDto> findAllPosts() {
         List<Post> posts = postRepository.findAll();

         return posts.stream()
                 .map(PostMapper::mapToPostDto)
                 .collect(Collectors.toList());
    }
}
