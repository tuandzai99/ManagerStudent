package com.tuanother.models;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "admin")

public class Admin {

	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
//
//	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "admin_role",
	joinColumns = @JoinColumn(name = "admin_id"),
	inverseJoinColumns =@JoinColumn(name = "role_id") )
	private Set<Role> roles=new HashSet<>();

	public Admin(){

	}

	public Admin(String username, String password, Set<Role> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
