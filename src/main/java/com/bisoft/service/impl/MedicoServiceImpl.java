package com.bisoft.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bisoft.dao.IMedicoDAO;
import com.bisoft.model.Medico;
import com.bisoft.service.IMedicoService;


@Service
public class MedicoServiceImpl implements IMedicoService{

	
	@Autowired
	private IMedicoDAO dao;
	
	@Override
	public Medico registrar(Medico t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Medico modificar(Medico t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);;
	}

	@Override
	
	public Medico listarId(int id) {
	
		return null;
		//return dao.findOne(Medico);
	}

	@Override
	public List<Medico> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void particular1() {
		// TODO Auto-generated method stub
		
	}


}
