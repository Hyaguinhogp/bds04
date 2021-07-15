package com.devsuperior.bds04.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.bds04.dto.UserDTO;
import com.devsuperior.bds04.dto.UserInsertDTO;
import com.devsuperior.bds04.dto.UserUpdateDTO;
import com.devsuperior.bds04.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/paged")
	public ResponseEntity<Page<UserDTO>> findAllPaged(Pageable pageable){
		Page<UserDTO> list = userService.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<UserDTO> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id){
		UserDTO dto = userService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> Insert(@Valid @RequestBody UserInsertDTO body){
		UserDTO dto = userService.insertUser(body);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<UserDTO> Update(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO dto){
		dto = userService.updateUser(id, dto);
		return ResponseEntity.ok().body(dto);
	}
}