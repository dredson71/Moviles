package com.hampcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hampcode.model.Discografica;

@Repository
public interface DiscograficaRepository extends 
			JpaRepository<Discografica,Long> {

}
