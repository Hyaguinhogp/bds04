package com.devsuperior.bds04.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.UserDTO;
import com.devsuperior.bds04.dto.UserInsertDTO;
import com.devsuperior.bds04.dto.UserUpdateDTO;
import com.devsuperior.bds04.entities.User;
import com.devsuperior.bds04.repositories.RoleRepository;
import com.devsuperior.bds04.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable){
		Page<User> list = userRepository.findAll(pageable);
		return list.map(user -> new UserDTO(user));
	}
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll(){
		List<UserDTO> list = userRepository.findAll().stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
		return list;
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		return new UserDTO(userRepository.findById(id).get());
	}
	
	@Transactional
	public UserDTO insertUser(UserInsertDTO dto) {
		User entity = new User();
		
		copyDtoToEntity(dto, entity);
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		
		userRepository.save(entity);
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserUpdateDTO updateUser(Long id, UserUpdateDTO dto) {
		
		User entity = new User();
		
		entity.setId(id);
		copyDtoToEntity(dto, entity);
		
		userRepository.save(entity);
		return new UserUpdateDTO(entity);
	}
	
	@Transactional
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.getRoles().clear();
		dto.getRoles().forEach(role -> entity.getRoles().add(roleRepository.getOne(role.getId())));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByName(username);
		if(user == null) {
			logger.error("User not found: " + username);
			throw new UsernameNotFoundException("Username not found");
		}
		logger.info("User found: " + username);
		return user;
	}
}
