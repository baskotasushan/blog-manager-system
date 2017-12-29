package com.blog.blogmanager.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.blogmanager.domain.Post;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long>{

	
}
