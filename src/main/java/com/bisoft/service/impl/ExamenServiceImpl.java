package com.bisoft.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bisoft.dao.IExamenDAO;
import com.bisoft.model.Examen;
import com.bisoft.service.IExamenService;


@Service
public class ExamenServiceImpl implements IExamenService{

	
	@Autowired
	private IExamenDAO dao;
	
	@Override
	public Examen registrar(Examen t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Examen modificar(Examen t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);;
	}

	@Override
	
	public Examen listarId(int id) {
	
		return null;
		//return dao.findOne(Examen);
	}

	@Override
	public List<Examen> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void particular1() {
		// TODO Auto-generated method stub
		
	}


}
