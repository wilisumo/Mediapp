package com.bisoft.service;

import com.bisoft.dto.ConsultaListaExamenDTO;
import com.bisoft.model.Consulta;


public interface IConsultaService extends ICRUD<Consulta> {

	void particular1();//cosas particulares adicionales al CRUD.
	
	Consulta registrarTransaccional(ConsultaListaExamenDTO consultaDTO);
	
}
