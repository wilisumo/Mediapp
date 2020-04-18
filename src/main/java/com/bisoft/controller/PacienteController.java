package com.bisoft.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
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

import com.bisoft.exception.ModeloNotFoundException;
import com.bisoft.model.Paciente;
import com.bisoft.service.IPacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	
	@Autowired
	private IPacienteService service;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Paciente>> listar(){
		List<Paciente> pacientes = new ArrayList<>();
		pacientes = service.listar();
		return new ResponseEntity<List<Paciente>>(pacientes,HttpStatus.OK);
	}
	
	
	@GetMapping(value="/{id}", produces = "application/json")
	public Resource<Paciente> listarPorId(@PathVariable("id") Integer id){
		Paciente pac =service.listarId(id);
		if(pac ==null) {	
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		//optional
		Resource<Paciente> resource = new Resource<Paciente>(pac);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("paciente-resource"));
		
		
		//return service.listarId(id);
		
		return resource;
	}
	/*
	@GetMapping(value="/{id}", produces = "application/json")
	public Paciente listarPorId(@PathVariable("id") Integer id){
		Paciente pac =service.listarId(id);
		if(pac ==null) {	
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		//optional
		//Resource<Paciente> resource = new Resource<Paciente>(pac);
		//ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		//resource.add(linkTo.withRel("paciente-resource"));
		
		
		return service.listarId(id);
		
		//return resource;
	}
	*/
	
	
	@PostMapping(produces="application/json",consumes="application/json" )
	public ResponseEntity<Object> registrar(@RequestBody Paciente paciente) {
		Paciente pac = new Paciente();
		pac = service.registrar(paciente);
		//pac.getIdPaciente() es la parte dinamica que reemplaza el {id} que es el id del paciente que acabo de crear
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getIdPaciente()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces="application/json",consumes="application/json" )
	public ResponseEntity<Object>modificar(@RequestBody Paciente paciente) {
		service.modificar(paciente);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminar(@PathVariable Integer id) {
		Paciente pac = service.listarId(id);
		if(pac==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+id);
		}else {
			service.eliminar(id);
		}
	}
	
}
