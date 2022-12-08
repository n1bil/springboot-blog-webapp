package com.example.springbootblogwebapp.service.impl;

import com.example.springbootblogwebapp.dto.CommentDto;
import com.example.springbootblogwebapp.entity.Comment;
import com.example.springbootblogwebapp.entity.Post;
import com.example.springbootblogwebapp.mapper.CommentMapper;
import com.example.springbootblogwebapp.repository.CommentRepository;
import com.example.springbootblogwebapp.repository.PostRepository;
import com.example.springbootblogwebapp.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void createComment(String postUrl, CommentDto commentDto) {

        Post post = postRepository.findByUrl(postUrl).get();
        Comment comment = CommentMapper.mapToComment(commentDto);
        comment.setPost(post);
        commentRepository.save(comment);
    }
}
