package com.joaoluis.employeeapi.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joaoluis.employeeapi.entities.Position;
import com.joaoluis.employeeapi.entities.Sector;
import com.joaoluis.employeeapi.entities.Worker;
import com.joaoluis.employeeapi.repositories.PositionRepository;
import com.joaoluis.employeeapi.repositories.SectorRepository;
import com.joaoluis.employeeapi.repositories.WorkerRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private WorkerRepository workerRepository;
	
	@Autowired
	private SectorRepository sectorRepository;
	
	@Autowired
	private PositionRepository positionRepository;

	@Override
	public void run(String... args) throws Exception {				
		
		Position p1 = new Position(null, "recepcionista");
		Position p2 = new Position(null, "diretor de marketing");
		
		
		Sector s1 = new Sector(null, "executivo");
		Sector s2 = new Sector(null, "marketing");
		s1.getPositions().add(p1);
		s2.getPositions().add(p2);
		
		Worker w1 = new Worker(null, "123.456.789-00", "Jhonathan", "male", s1, p1);
		Worker w2 = new Worker(null, "123.456.789-01", "Paula", "woman", s2, p2);
		
		workerRepository.saveAll(Arrays.asList(w1, w2));
		positionRepository.saveAll(Arrays.asList(p1, p2));
		sectorRepository.saveAll(Arrays.asList(s1, s2));
		
	}
	
	
}
