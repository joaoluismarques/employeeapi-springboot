package com.joaoluis.employeeapi.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joaoluis.employeeapi.entities.Worker;
import com.joaoluis.employeeapi.repositories.WorkerRepository;
import com.joaoluis.employeeapi.services.exceptions.DatabaseException;
import com.joaoluis.employeeapi.services.exceptions.ResourceNotFoundException;

@Service
public class WorkerService {
	
	@Autowired
	private WorkerRepository repository;

	public List<Worker> findAll() {
		return repository.findAll();
	}
		
	public Worker finByCpf( String cpf) {
		Optional<Worker> obj = repository.findByCpf(cpf);
		return obj.orElseThrow(() -> new ResourceNotFoundException(cpf));
	}
	
	public Worker insert(Worker obj) {
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
	
	public Worker update(Long id, Worker obj ) {
		try {
			Worker entity = repository.getById(id);		
		    update(entity, obj);
		    return repository.save(entity);
		} catch (EntityNotFoundException exception) {
			throw new ResourceNotFoundException(id);
		}    
	}

	private void update(Worker entity, Worker obj) {
		entity.setCpf(obj.getCpf());
		entity.setName(obj.getName());
		entity.setGender(obj.getGender());		
	}
}

