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

import com.hampcode.model.Discografica;
import com.hampcode.repository.DiscograficaRepository;

@RestController
@RequestMapping("/api/discografica")
@CrossOrigin
public class DiscograficaController {

	@Autowired
	private DiscograficaRepository discograficaRepository;

	
	@GetMapping
	public List<Discografica> all() {
		List<Discografica> discograficas = this.discograficaRepository.findAll();
		return discograficas;
	}

	@PostMapping
	public Discografica save(@RequestBody Discografica discografica, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}

		
		Discografica discograficaNew=this.discograficaRepository.save(discografica);

		return discograficaNew;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.discograficaRepository.deleteById(id);
	}

}