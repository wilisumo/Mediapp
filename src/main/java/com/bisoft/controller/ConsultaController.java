package com.bisoft.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bisoft.dto.ConsultaDTO;
import com.bisoft.dto.ConsultaListaExamenDTO;
import com.bisoft.model.Consulta;
import com.bisoft.service.IConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	
	@Autowired
	private IConsultaService service;
	
	@GetMapping(produces = "application/json")
	public List<Consulta> listar(){
		return service.listar();
	}
	
	@GetMapping(value="/{id}", produces = "application/json")
	public Consulta listarPorId(@PathVariable("id") Integer id){
		return service.listarId(id);
	}
	
	@PostMapping(produces="application/json",consumes="application/json" )
	public Consulta registrar(@RequestBody ConsultaListaExamenDTO consultaDTO) {
		
		return service.registrarTransaccional(consultaDTO);
		
	}
	
	@PutMapping(produces="application/json",consumes="application/json" )
	public Consulta modificar(@RequestBody Consulta consulta) {
		
		return service.modificar(consulta);
		
	}
	
	
	@DeleteMapping(consumes="application/json" )
	public void eliminar(@PathVariable Integer id) {
		service.eliminar(id);
		
	}
	
	
	@GetMapping(value= "/hateoas",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ConsultaDTO> listarHateoas(){
		
		List<Consulta> consultas = new ArrayList<>();
		List<ConsultaDTO> consultasDTO = new ArrayList<>();
		consultas = service.listar();
		
		for(Consulta c: consultas) {
			ConsultaDTO d = new ConsultaDTO();
			d.setIdConsulta(c.getIdConsulta());
			d.setMedico(c.getMedico());
			d.setPaciente(c.getPaciente());

			
			ControllerLinkBuilder linkTo = linkTo(methodOn(ConsultaController.class).listarPorId(c.getIdConsulta()));
			d.add(linkTo.withSelfRel());
			consultasDTO.add(d);
			

			//ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
			
			ControllerLinkBuilder linkTo1 = linkTo(methodOn(ConsultaController.class).listarPorId(c.getPaciente().getIdPaciente()));
			d.add(linkTo1.withSelfRel());
			consultasDTO.add(d);
			

			ControllerLinkBuilder linkTo2 = linkTo(methodOn(ConsultaController.class).listarPorId(c.getMedico().getIdMedico()));
			d.add(linkTo2.withSelfRel());
			consultasDTO.add(d);
			
			
		}
		return consultasDTO;
		
	}
	
	
	
}
