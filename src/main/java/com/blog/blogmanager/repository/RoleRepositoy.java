package com.blog.blogmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blogmanager.domain.Role;
import com.blog.blogmanager.domain.RoleName;

public interface RoleRepositoy extends JpaRepository<Role, Long>{

	Role findByName(RoleName role);
}
