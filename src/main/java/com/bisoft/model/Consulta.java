package com.bisoft.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name="consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsulta;
	
	 //dentro del JSON no tome en cuenta a consulta para no crear un loop infinito
	
	@ManyToOne
	@JoinColumn(name = "id_paciente",nullable=false)
	private Paciente paciente;
	
	
	@ManyToOne
	@JoinColumn(name="id_medico",nullable=false)
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name="id_especialidad",nullable=false)
	private Especialidad especialidad;
	
	
	//@JsonSerialize(using = ToStringSerializer.class)//ISODATE 2018-01-01T05:00:00.000
	//private LocalDateTime fecha;
	
	private Timestamp fecha;

	
	//cascade si algo le pasa al padre le afecta al hijo
	//fetch type el alcance del objeto hacia la lista
	//* from lazy jala data de solo de la tabla maestra
	//EAGER los datos del padre y del hijo
	//no conviene tener EAGER por todo por rendimiento
	//OrphanRemoval si su lista tiene detalle 1,2,3,4 para poder remover un registro un solo registro.
	//Merge actualziar o modificar
	
	@OneToMany(mappedBy="consulta", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE},fetch= FetchType.LAZY,orphanRemoval=true) //maestro detalle
	private List<DetalleConsulta> detalleConsulta;

	
	
	public List<DetalleConsulta> getDetalleConsulta() {
		return detalleConsulta;
	}


	public void setDetalleConsulta(List<DetalleConsulta> detalleConsulta) {
		this.detalleConsulta = detalleConsulta;
	}


	public Integer getIdConsulta() {
		return idConsulta;
	}


	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public Especialidad getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}


	public Timestamp getFecha() {
		return fecha;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idConsulta == null) ? 0 : idConsulta.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (idConsulta == null) {
			if (other.idConsulta != null)
				return false;
		} else if (!idConsulta.equals(other.idConsulta))
			return false;
		return true;
	}


	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}


	
}
