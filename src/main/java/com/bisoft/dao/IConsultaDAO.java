package com.bisoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bisoft.model.Consulta;

public interface IConsultaDAO extends JpaRepository<Consulta,Integer> {

}
