package com.bisoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bisoft.model.Medico;

public interface IMedicoDAO extends JpaRepository<Medico,Integer> {

}
