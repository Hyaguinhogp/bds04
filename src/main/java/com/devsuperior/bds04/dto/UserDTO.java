package com.devsuperior.bds04.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.devsuperior.bds04.entities.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "O campo não pode ser vazio")
	private String name;
	
	@Valid
	private Set<RoleDTO> roles = new HashSet<>();
	
	public UserDTO() {
	}

	public UserDTO(Long id, String name, String password) {
		this.id = id;
		this.name = name;
	}
	
	public UserDTO(User user) {
		id = user.getId();
		name = user.getName();
		user.getRoles().forEach(role -> roles.add(new RoleDTO(role)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}
}