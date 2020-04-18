package com.bisoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bisoft.model.Paciente;

public interface IPacienteDAO extends JpaRepository<Paciente,Integer>{

	
	
}
