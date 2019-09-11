package com.hampcode.api.viewmodel;

import java.util.Date;

public class DiscoViewModel {

	private Long id;
	private String nombre;
	private String descripcion;
	private Date fecha;
	private Long artistaId;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Long getArtistaId() {
		return artistaId;
	}
	public void setArtistaId(Long artistaId) {
		this.artistaId = artistaId;
	}
	
}
