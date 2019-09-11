package com.hampcode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hampcode.model.Artista;
import com.hampcode.model.Cancion;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Long> {

	@Query(value = "SELECT * FROM Cancion WHERE artista_id=?1",
			nativeQuery = true)
	List<Cancion> getByArtista(Artista artista);
	
	@Query("SELECT a FROM Cancion a WHERE a.artista.id=?1")
	List<Cancion> getAllByArtista(Artista artista);
	
	List<Cancion> findAllByArtista(Artista artista);
}
