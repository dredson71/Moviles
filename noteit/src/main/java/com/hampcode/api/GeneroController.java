package com.hampcode.api;

import java.util.List;

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

import com.hampcode.model.Genero;
import com.hampcode.repository.GeneroRepository;

@RestController
@RequestMapping("/api/genero")
@CrossOrigin
public class GeneroController {

	@Autowired
	private GeneroRepository generoRepository;

	
	@GetMapping
	public List<Genero> all() {
		List<Genero> generos = this.generoRepository.findAll();
		return generos;
	}

	@PostMapping
	public Genero save(@RequestBody Genero genero, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}

		
		Genero generoNew=this.generoRepository.save(genero);

		return generoNew;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.generoRepository.deleteById(id);
	}

}