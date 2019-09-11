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
@RequestMapping("/api/disco")
@CrossOrigin
public class DiscoController {

	@Autowired
	private DiscoRepository discoRepository;
	@Autowired
	private ArtistaRepository artistaRepository;
	
	
	
	@Autowired
	private Mapper mapper;

	@GetMapping
	public List<DiscoViewModel> all() {
		List<Disco> discos = this.discoRepository.findAll();

		List<DiscoViewModel> discosViewModel = discos
				.stream()
				.map(disco -> this.mapper.convertToDiscoViewModel(disco))
				.collect(Collectors.toList());

		return discosViewModel;
	}

	@GetMapping("/{id}")
	public DiscoViewModel byId(@PathVariable Long id) {
		Disco disco = this.discoRepository.findById(id).orElse(null);

		if (disco == null) {
			throw new EntityNotFoundException();
		}

		DiscoViewModel discoViewModel = this.mapper.convertToDiscoViewModel(disco);

		return discoViewModel;
	}

	@GetMapping("/byArtista/{artistaId}")
	public List<DiscoViewModel> byArtista(@PathVariable Long artistaId) {
		List<Disco> discos = new ArrayList<>();

		Optional<Artista> artista = this.artistaRepository.findById(artistaId);
		if (artista.isPresent()) {
			discos = this.discoRepository.findAllByArtista(artista.get());
		}

		// map to note view model
		List<DiscoViewModel>discosViewModel = discos.stream().map(disco -> this.mapper.convertToDiscoViewModel(disco))
				.collect(Collectors.toList());

		return discosViewModel;
	}

	@PostMapping
	public Disco save(@RequestBody DiscoViewModel discoCreateViewModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}

		Disco discoEntity = this.mapper.convertToDiscoEntity(discoCreateViewModel);

		// save note instance to db
		this.discoRepository.save(discoEntity);

		return discoEntity;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.discoRepository.deleteById(id);
	}

}