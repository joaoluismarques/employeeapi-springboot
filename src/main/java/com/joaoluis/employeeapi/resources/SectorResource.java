package com.joaoluis.employeeapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joaoluis.employeeapi.entities.Sector;
import com.joaoluis.employeeapi.services.SectorService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/sectors")
public class SectorResource {

	@Autowired
	private SectorService service;
	
	@GetMapping
	@ApiOperation("Api retorna uma lista de setores")
	public ResponseEntity<List<Sector>> findAll() {
		List<Sector> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	@ApiOperation("Api retorna uma setor específico")
	public ResponseEntity<Sector> findById(@PathVariable Long id) {
		Sector obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	@ApiOperation("Api adiciona um setor")
	public ResponseEntity<Sector> insert(@RequestBody Sector obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation("Api deleta um setor")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "/{id}")
	@ApiOperation("Api responsável por ataulizar um setor")
	public ResponseEntity<Sector> update(@PathVariable Long id, @RequestBody Sector obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
