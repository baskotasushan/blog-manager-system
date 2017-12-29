package com.blog.blogmanager.service;

import com.blog.blogmanager.domain.User;

public interface UserService {

	public void save(User user);
	public User findByUsername(String username);
}
