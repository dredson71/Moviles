package com.hampcode.api.viewmodel;

import java.util.Date;

import javax.validation.constraints.NotNull;


public class ArtistaViewModel {
	
	private Long id;
	private String sexo;
	private int edad;
	private String nombreArtistico;
	@NotNull
	private String correo;
	@NotNull
	private String contraseña;
	private boolean permisoNotificaciones;
	private Date fecha;
	private boolean activo;
	
	private Long generoId;
	private Long discograficaId;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombreArtistico() {
		return nombreArtistico;
	}

	public void setNombreArtistico(String nombreArtistico) {
		this.nombreArtistico = nombreArtistico;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public boolean isPermisoNotificaciones() {
		return permisoNotificaciones;
	}

	public void setPermisoNotificaciones(boolean permisoNotificaciones) {
		this.permisoNotificaciones = permisoNotificaciones;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Long getDiscograficaId() {
		return discograficaId;
	}

	public void setDiscograficaId(Long discograficaId) {
		this.discograficaId = discograficaId;
	}

	public Long getGeneroId() {
		return generoId;
	}

	public void setGeneroId(Long generoId) {
		this.generoId = generoId;
	}
}
