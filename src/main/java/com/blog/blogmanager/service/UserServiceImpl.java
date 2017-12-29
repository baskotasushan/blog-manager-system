package com.blog.blogmanager.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.blogmanager.domain.Role;
import com.blog.blogmanager.domain.User;
import com.blog.blogmanager.repository.RoleRepositoy;
import com.blog.blogmanager.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepositoy roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		for(Role role: user.getRoles()) {
			roleRepository.save(role);
		}
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);	
	}

	@Override
	public User findByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

}
