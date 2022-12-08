package com.example.springbootblogwebapp.repository;

import com.example.springbootblogwebapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
