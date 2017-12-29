package com.blog.blogmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blogmanager.domain.Post;
import com.blog.blogmanager.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public void savePost(Post post) {
		postRepository.save(post);
	}

}
