package com.blog.blogmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blogmanager.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
}
