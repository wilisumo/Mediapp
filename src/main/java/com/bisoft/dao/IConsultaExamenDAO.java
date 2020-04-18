package com.bisoft.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bisoft.model.ConsultaExamen;

public interface IConsultaExamenDAO extends JpaRepository<ConsultaExamen, Integer>{

	
	//toda notacion modify necesita la notacion transactional
	//@Transactional //ya esta en otra en la implementacion no es necesario doble
	//MODIFICATION SENTENCE DML
	@Modifying
	@Query(value= "INSERT INTO consulta_examen(id_consulta,id_examen) VALUES (:idConsulta, :idExamen)",nativeQuery= true)
	Integer registrar(@Param("idConsulta" )Integer idConsulta,@Param("idExamen") Integer idExamen);
	
}
