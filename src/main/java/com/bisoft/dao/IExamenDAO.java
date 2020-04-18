package com.bisoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bisoft.model.Examen;

public interface IExamenDAO extends JpaRepository<Examen, Integer> {

}
