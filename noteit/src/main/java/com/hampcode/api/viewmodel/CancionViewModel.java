package com.hampcode.api.viewmodel;

import java.util.Date;


public class CancionViewModel {

	private Long id;
	private String nombre;
	private Date fecha;
	private String contenido;
	private String url;
	private boolean estadoPublico;
	
	private Long generoId;
	private Long artistaId;
	private Long discoId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public boolean isEstadoPublico() {
		return estadoPublico;
	}

	public void setEstadoPublico(boolean estadoPublico) {
		this.estadoPublico = estadoPublico;
	}

	public Long getGeneroId() {
		return generoId;
	}

	public void setGeneroId(Long generoId) {
		this.generoId = generoId;
	}

	public Long getArtistaId() {
		return artistaId;
	}

	public void setArtistaId(Long artistaId) {
		this.artistaId = artistaId;
	}

	public Long getDiscoId() {
		return discoId;
	}

	public void setDiscoId(Long discoId) {
		this.discoId = discoId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	


	

}
