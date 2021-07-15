package com.devsuperior.bds04.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import com.devsuperior.bds04.entities.Role;

public class RoleDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@PositiveOrZero(message = "O id não pode ser negativo")
	private Long id;
	
	private String authority;
	
	public RoleDTO() {
	}

	public RoleDTO(Long id, String authority) {
		super();
		this.id = id;
		this.authority = authority;
	}

	public RoleDTO(Role role) {
		id = role.getId();
		authority = role.getAuthority();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}