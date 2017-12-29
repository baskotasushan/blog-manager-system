package com.blog.blogmanager.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="role_table")
@Data
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private RoleName name;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<>();
}
