package com.hampcode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hampcode.model.Artista;
import com.hampcode.model.Genero;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {

	@Query(value = "SELECT * FROM Artista WHERE genero_id=?1",
			nativeQuery = true)
	List<Artista> getByGenero(Genero genero);
	
	@Query("SELECT a FROM Artista a WHERE a.genero.id=?1")
	List<Artista> getAllByGenero(Genero genero);
	
	List<Artista> findAllByGenero(Genero genero);
}
