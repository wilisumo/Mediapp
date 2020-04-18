package com.bisoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bisoft.dao.IConsultaDAO;
import com.bisoft.dao.IConsultaExamenDAO;
import com.bisoft.dto.ConsultaListaExamenDTO;
import com.bisoft.model.Consulta;
import com.bisoft.model.DetalleConsulta;
import com.bisoft.service.IConsultaService;

@Service //para poder implementarlo en la capa controller
public class ConsultaServiceImpl implements IConsultaService{

	
	
	@Autowired
	private IConsultaDAO dao;
	
	@Autowired
	private IConsultaExamenDAO cedao; 
	
	
	@Transactional //si sucede algun error no inserte nada
	@Override
	public Consulta registrarTransaccional(ConsultaListaExamenDTO consultaDTO) {
		/*
		for(DetalleConsulta de: consulta.getDetalleConsulta()) {
			de.setConsulta(consulta);
		}
		*/
		consultaDTO.getConsulta().getDetalleConsulta().forEach(d -> {
			d.setConsulta(consultaDTO.getConsulta());		
		});
		dao.save(consultaDTO.getConsulta());
		
		//for each examen insert
		consultaDTO.getLstExamen().forEach(e -> cedao.registrar(consultaDTO.getConsulta().getIdConsulta(),e.getIdExamen()));
		
		
		return consultaDTO.getConsulta();
		
	}

	@Override
	public Consulta modificar(Consulta t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		
		dao.deleteById(id);
	}

	@Override
	public Consulta listarId(int id) {
		
		return null;
		//return dao.findById(id);
	}

	@Override
	public List<Consulta> listar() {
		
		return dao.findAll();
	}

	@Override
	public void particular1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Consulta registrar(Consulta t) {
		// TODO Auto-generated method stub
		return null;
	}

}
