package com.antonzemskov.blog.repo;

import com.antonzemskov.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
