package com.hampcode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hampcode.model.Artista ;
import com.hampcode.model.Disco;

@Repository
public interface DiscoRepository extends JpaRepository<Disco, Long> {

	@Query(value = "SELECT * FROM Disco WHERE artista_id=?1",
			nativeQuery = true)
	List<Disco> getByArtista (Artista artista);
	
	@Query("SELECT a FROM Disco a WHERE a.artista.id=?1")
	List<Disco> getAllByArtista (Artista artista);
	
	List<Disco> findAllByArtista (Artista artista);
}
