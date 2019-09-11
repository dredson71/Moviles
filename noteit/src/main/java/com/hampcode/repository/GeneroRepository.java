package com.hampcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hampcode.model.Genero;

@Repository
public interface GeneroRepository extends 
			JpaRepository<Genero,Long> {

}
