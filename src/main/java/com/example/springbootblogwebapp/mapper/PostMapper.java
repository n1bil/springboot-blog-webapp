package com.example.springbootblogwebapp.mapper;

import com.example.springbootblogwebapp.dto.CommentDto;
import com.example.springbootblogwebapp.dto.PostDto;
import com.example.springbootblogwebapp.entity.Comment;
import com.example.springbootblogwebapp.entity.Post;

import java.util.stream.Collectors;

public class PostMapper {

    // map Post entity to PostDto
    public static PostDto mapToPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .url(post.getUrl())
                .content(post.getContent())
                .shortDescription(post.getShortDescription())
                .createdOn(post.getCreatedOn())
                .updatedOn(post.getUpdateOn())
                .comments(post.getComments().stream()
                        .map(CommentMapper::mapToCommentDto)
                        .collect(Collectors.toSet()))
                .build();
    }

    // map PostDto to Post entity
    public static Post mapToPost(PostDto postDto) {
        return Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .url(postDto.getUrl())
                .content(postDto.getContent())
                .shortDescription(postDto.getShortDescription())
                .createdOn(postDto.getCreatedOn())
                .updateOn(postDto.getUpdatedOn())
                .build();
    }
}
