package com.example.springbootblogwebapp.service;

import com.example.springbootblogwebapp.dto.CommentDto;

public interface CommentService {

    void createComment(String postUrl, CommentDto commentDto);
}
