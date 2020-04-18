package com.bisoft.dto;

import org.springframework.hateoas.ResourceSupport;

import com.bisoft.model.Medico;
import com.bisoft.model.Paciente;

public class ConsultaDTO extends ResourceSupport{

	private int idConsulta;
	private Medico medico;
	private Paciente paciente;
	
	
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	
}
