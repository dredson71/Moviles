package com.hampcode.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Discografica")
public class Discografica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String correoEmpresarial;
	private String pais;

	public Discografica() {
		// TODO Auto-generated constructor stub
	}

	public Discografica(Long id, String correoEmpresarial, String pais) {
		super();
		this.id = id;
		this.correoEmpresarial = correoEmpresarial;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCorreoEmpresarial() {
		return correoEmpresarial;
	}

	public void setCorreoEmpresarial(String correoEmpresarial) {
		this.correoEmpresarial = correoEmpresarial;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	

}
