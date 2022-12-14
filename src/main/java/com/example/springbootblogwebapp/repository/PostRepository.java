package com.example.springbootblogwebapp.repository;

import com.example.springbootblogwebapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByUrl(String url);

    @Query("select info from Post info where " +
            "info.title like concat('%', :query, '%') or " +
            "info.shortDescription like concat('%', :query, '%') ")
    List<Post> searchPosts(String query);

    @Query(value = "select * from posts post where post.created_by =:userId", nativeQuery = true)
    List<Post> findPostsByUser(Long userId);
}
