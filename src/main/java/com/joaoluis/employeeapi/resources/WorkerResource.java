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

import com.joaoluis.employeeapi.entities.Worker;
import com.joaoluis.employeeapi.services.WorkerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Autowired
	private WorkerService service;
	
	@GetMapping
	@ApiOperation("Api responsável por buscar uma lista de trabalhadores")
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}		
	
    @GetMapping(value = "/{cpf}")
    @ApiOperation("Api busca um trabalhador através do cpf")
	public ResponseEntity<Worker> findByCpf(@PathVariable String cpf) {
		Worker obj = service.finByCpf(cpf);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@ApiOperation("Api responsável por adicionar um trabalhador")
	public ResponseEntity<Worker> insert(@RequestBody Worker obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation("Api responsável por deletar um trabalhador")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	@ApiOperation("Api responsável por atualizar um trabalhador")
	public ResponseEntity<Worker> update(@PathVariable Long id, @RequestBody Worker obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
