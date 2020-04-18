package com.bisoft.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bisoft.dao.IEspecialidadDAO;
import com.bisoft.model.Especialidad;
import com.bisoft.service.IEspecialidadService;


@Service
public class EspecialidadServiceImpl implements IEspecialidadService{

	
	@Autowired
	private IEspecialidadDAO dao;
	
	@Override
	public Especialidad registrar(Especialidad t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Especialidad modificar(Especialidad t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);;
	}

	@Override
	
	public Especialidad listarId(int id) {
	
		return null;
		//return dao.findOne(Especialidad);
	}

	@Override
	public List<Especialidad> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void particular1() {
		// TODO Auto-generated method stub
		
	}


}
