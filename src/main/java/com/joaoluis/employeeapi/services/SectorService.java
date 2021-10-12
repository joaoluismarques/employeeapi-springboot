package com.joaoluis.employeeapi.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joaoluis.employeeapi.entities.Sector;
import com.joaoluis.employeeapi.repositories.SectorRepository;
import com.joaoluis.employeeapi.services.exceptions.DatabaseException;
import com.joaoluis.employeeapi.services.exceptions.ResourceNotFoundException;

@Service
public class SectorService {

	@Autowired
	private SectorRepository repository;
	
	public List<Sector> findAll() {
		return repository.findAll();
	}
	
	public Sector findById(Long id) {
		Optional<Sector> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Sector insert(Sector obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException exception) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException exception) {
			throw new DatabaseException(exception.getMessage());
		}
	}
	
	public Sector update(Long id, Sector obj ) {
		try {
			Sector entity = repository.getById(id);
		    update(entity, obj);
		    return repository.save(entity);
		} catch (EntityNotFoundException exception) {
			throw new ResourceNotFoundException(id);
		} 
	}

	private void update(Sector entity, Sector obj) {
		entity.setName(obj.getName());	
	}
}
