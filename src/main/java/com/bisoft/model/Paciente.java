package com.bisoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Informacion del paciente")
@Entity
@Table(name = "paciente")
public class Paciente {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;
	
	@ApiModelProperty(notes = "Nombre debe tener minimo 3 caracteres")
	@Size(min = 3,message = "Nombre debe tener minimo 3 caracteres")
	@Column(name = "nombres", nullable=false, length=70)
	private String nombres;
	
	@ApiModelProperty(notes = "Apellido debe tener minimo 3 caracteres")
	@Size(min = 3,message = "Apellido debe tener minimo 3 caracteres")
	@Column(name = "apellidos", nullable=false, length=70)
	private String apellidos;
	
	@ApiModelProperty(notes = "DNI debe tener minimo 3 caracteres")
	@Size(min = 8,max=10,message = "DNI debe tener minimo 8 caracteres y maximo 12")
	@Column(name = "dni", nullable=false, length=12)  //,unique=true)
	private String dni;
	
	@Column(name = "direccion", nullable=false, length=150)
	private String direccion;
	
	@Column(name = "telefono", nullable=false, length=9)
	private String telefono;
	
	@Column(name = "email", nullable=false, length=80)
	private String email;
	
	public Integer getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
