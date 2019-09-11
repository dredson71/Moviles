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
import com.hampcode.api.viewmodel.*;
import com.hampcode.model.*;
import com.hampcode.repository.*;

@RestController
@RequestMapping("/api/cancion")
@CrossOrigin
public class CancionController {

	@Autowired
	private ArtistaRepository artistaRepository;
	@Autowired
	private CancionRepository cancionRepository;
	
	
	
	@Autowired
	private Mapper mapper;

	@GetMapping
	public List<CancionViewModel> all() {
		List<Cancion> canciones = this.cancionRepository.findAll();

		List<CancionViewModel> cancionesViewModel = canciones
				.stream()
				.map(cancion -> this.mapper.convertToCancionViewModel(cancion))
				.collect(Collectors.toList());

		return cancionesViewModel;
	}

	@GetMapping("/{id}")
	public CancionViewModel byId(@PathVariable Long id) {
		Cancion cancion = this.cancionRepository.findById(id).orElse(null);

		if (cancion == null) {
			throw new EntityNotFoundException();
		}

		CancionViewModel cancionViewModel = this.mapper.convertToCancionViewModel(cancion);

		return cancionViewModel;
	}

	@GetMapping("/byArtista/{artistaId}")
	public List<CancionViewModel> byArtista(@PathVariable Long artistaId) {
		List<Cancion> canciones = new ArrayList<>();

		Optional<Artista> artista = this.artistaRepository.findById(artistaId);
		if (artista.isPresent()) {
			canciones = this.cancionRepository.findAllByArtista(artista.get());
		}

		// map to note view model
		List<CancionViewModel> cancionesViewModel = canciones.stream().map(cancion -> this.mapper.convertToCancionViewModel(cancion))
				.collect(Collectors.toList());

		return cancionesViewModel;
	}

	@PostMapping
	public Cancion save(@RequestBody CancionViewModel cancionCreateViewModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}

		Cancion cancionEntity = this.mapper.convertToCancionEntity(cancionCreateViewModel);

		// save note instance to db
		this.cancionRepository.save(cancionEntity);

		return cancionEntity;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.cancionRepository.deleteById(id);
	}

}