package com.devsuperior.bds04.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.CityRepository;
import com.devsuperior.bds04.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Transactional(readOnly = true)
	public List<EventDTO> findAll(){
		List<Event> events = repository.findAll();
		return events.stream().map(event -> new EventDTO(event)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public Page<EventDTO> findAllPaged(Pageable pageable){
		Page<Event> events = repository.findAll(pageable);
		return events.map(event -> new EventDTO(event));
	}
	
	@Transactional
	public EventDTO insert(EventDTO dto) {
		Event event = new Event();
		event.setName(dto.getName());
		event.setDate(dto.getDate());
		event.setUrl(dto.getUrl());
		event.setCity(cityRepository.getOne(dto.getCityId()));
		
		repository.save(event);
		
		return new EventDTO(event);
	}
}
