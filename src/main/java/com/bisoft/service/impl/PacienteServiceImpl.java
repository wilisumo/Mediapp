package com.bisoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bisoft.dao.IPacienteDAO;
import com.bisoft.model.Paciente;
import com.bisoft.service.IPacienteService;


@Service
public class PacienteServiceImpl implements IPacienteService{

	
	@Autowired
	private IPacienteDAO dao;
	
	@Override
	public Paciente registrar(Paciente t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Paciente modificar(Paciente t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);;
	}

	@Override
	public Paciente listarId(int id) {
		return null;
		//return dao.findOne(Paciente);
	}

	@Override
	public List<Paciente> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void particular1() {
		// TODO Auto-generated method stub
		
	}

}
