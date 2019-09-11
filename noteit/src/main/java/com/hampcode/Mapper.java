package com.hampcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hampcode.api.viewmodel.*;
import com.hampcode.repository.*;
import com.hampcode.model.*;


@Component
public class Mapper {

	@Autowired
	private GeneroRepository generoRepository;
	
	@Autowired
	private DiscograficaRepository discograficaRepository;
	@Autowired
	private ArtistaRepository artistaRepository;
	@Autowired
	private DiscoRepository discoRepository;

	public ArtistaViewModel convertToArtistaViewModel(Artista entity) {
		ArtistaViewModel viewModel = new ArtistaViewModel();
		viewModel.setActivo(entity.isActivo());
		viewModel.setContraseña(entity.getContraseña());
		viewModel.setCorreo(entity.getCorreo());
		viewModel.setEdad(entity.getEdad());
		viewModel.setFecha(entity.getFecha());
		viewModel.setId(entity.getId());
		viewModel.setNombreArtistico(entity.getNombreArtistico());
		viewModel.setPermisoNotificaciones(entity.isPermisoNotificaciones());
		viewModel.setSexo(entity.getSexo());
		viewModel.setDiscograficaId(entity.getDiscografica().getId());
		viewModel.setGeneroId(entity.getGenero().getId());

		return viewModel;
	}

	public Artista convertToArtistaEntity(ArtistaViewModel viewModel) {
		Genero genero = this.generoRepository.findById(viewModel.getGeneroId()).get();
		Discografica discografica=this.discograficaRepository.findById(viewModel.getDiscograficaId()).get();
		Artista entity = new Artista(viewModel.getId(),viewModel.getSexo(),viewModel.getEdad(),
				viewModel.getNombreArtistico(), viewModel.getCorreo(),viewModel.getContraseña(),
				viewModel.isPermisoNotificaciones(),viewModel.getFecha(),
				viewModel.isActivo(),discografica, genero);

		return entity;
	}

	public GeneroViewModel convertToGeneroViewModel(Genero entity) {
		GeneroViewModel viewModel = new GeneroViewModel();
		viewModel.setDetalle(entity.getDetalle());
		viewModel.setId(entity.getId());
		return viewModel;
	}

	public Genero convertToGeneroEntity(GeneroViewModel viewModel) {
		Genero entity = new Genero(viewModel.getId(), viewModel.getDetalle());

		return entity;
	}

	
	public DiscograficaViewModel convertToDiscograficaViewModel(Discografica entity) {
		DiscograficaViewModel viewModel = new DiscograficaViewModel();
		viewModel.setId(entity.getId());
		viewModel.setPais(entity.getPais());
		viewModel.setCorreoEmpresarial(entity.getCorreoEmpresarial());
		return viewModel;
	}

	public Discografica convertToDiscograficaEntity(DiscograficaViewModel viewModel) {
		Discografica entity = new Discografica(viewModel.getId(), viewModel.getCorreoEmpresarial(),viewModel.getPais());

		return entity;
	}
	
	public CancionViewModel convertToCancionViewModel(Cancion entity) {
		CancionViewModel viewModel = new CancionViewModel();
		viewModel.setContenido(entity.getContenido());
		viewModel.setEstadoPublico(entity.isEstadoPublico());
		viewModel.setFecha(entity.getFecha());
		viewModel.setId(entity.getId());
		viewModel.setNombre(entity.getNombre());
		viewModel.setUrl(entity.getUrl());
		viewModel.setArtistaId(entity.getArtista().getId());
		viewModel.setDiscoId(entity.getDisco().getId());
		viewModel.setGeneroId(entity.getGenero().getId());

		return viewModel;
	}

	public Cancion convertToCancionEntity(CancionViewModel viewModel) {
		Genero genero = this.generoRepository.findById(viewModel.getGeneroId()).get();
		Artista artista=this.artistaRepository.findById(viewModel.getArtistaId()).get();
		Disco disco=this.discoRepository.findById(viewModel.getDiscoId()).get();
		
		Cancion entity = new Cancion(viewModel.getId(),viewModel.getNombre(),viewModel.getFecha(),
				viewModel.getContenido(),viewModel.getUrl(),viewModel.isEstadoPublico(),
				artista,genero,disco);

		return entity;
	}
	
	public DiscoViewModel convertToDiscoViewModel(Disco entity) {
		DiscoViewModel viewModel= new DiscoViewModel();
		viewModel.setId(entity.getId());
		viewModel.setDescripcion(entity.getDescripcion());
		viewModel.setFecha(entity.getFecha());
		viewModel.setArtistaId(entity.getArtista().getId());
		viewModel.setNombre(entity.getNombre());
		
		return viewModel;
	}
	public Disco convertToDiscoEntity(DiscoViewModel viewModel) {
		Artista artista=this.artistaRepository.findById(viewModel.getArtistaId()).get();
		Disco entity= new Disco(viewModel.getId(),viewModel.getNombre(),viewModel.getDescripcion(),viewModel.getFecha(),
				artista);
		return entity;
	}
}