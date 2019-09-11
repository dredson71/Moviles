package com.hampcode.api;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hampcode.Mapper;
import com.hampcode.api.viewmodel.ArtistaViewModel;
import com.hampcode.model.Artista;
import com.hampcode.model.Genero;
import com.hampcode.repository.ArtistaRepository;
import com.hampcode.repository.GeneroRepository;

@RestController
@RequestMapping("/api/artista")
@CrossOrigin
public class ArtistaController {

	@Autowired
	private ArtistaRepository artistaRepository;
	@Autowired
	private GeneroRepository generoRepository;
	
	
	
	@Autowired
	private Mapper mapper;

	@GetMapping
	public List<ArtistaViewModel> all() {
		List<Artista> artistas = this.artistaRepository.findAll();

		List<ArtistaViewModel> artistasViewModel = artistas
				.stream()
				.map(artista -> this.mapper.convertToArtistaViewModel(artista))
				.collect(Collectors.toList());

		return artistasViewModel;
	}

	@GetMapping("/{id}")
	public ArtistaViewModel byId(@PathVariable Long id) {
		Artista artista = this.artistaRepository.findById(id).orElse(null);

		if (artista == null) {
			throw new EntityNotFoundException();
		}

		ArtistaViewModel artistaViewModel = this.mapper.convertToArtistaViewModel(artista);

		return artistaViewModel;
	}

	@GetMapping("/byGenero/{generoId}")
	public List<ArtistaViewModel> byGenero(@PathVariable Long generokId) {
		List<Artista> artistas = new ArrayList<>();

		Optional<Genero> genero = this.generoRepository.findById(generokId);
		if (genero.isPresent()) {
			artistas = this.artistaRepository.findAllByGenero(genero.get());
		}

		// map to note view model
		List<ArtistaViewModel> artistasViewModel = artistas.stream().map(artista -> this.mapper.convertToArtistaViewModel(artista))
				.collect(Collectors.toList());

		return artistasViewModel;
	}

	@PostMapping
	public Artista save(@RequestBody ArtistaViewModel artistaCreateViewModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}

		Artista artistaEntity = this.mapper.convertToArtistaEntity(artistaCreateViewModel);

		// save note instance to db
		this.artistaRepository.save(artistaEntity);

		return artistaEntity;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.artistaRepository.deleteById(id);
	}

}