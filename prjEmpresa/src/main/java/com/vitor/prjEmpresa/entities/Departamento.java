package com.vitor.prjEmpresa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "departamento")
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long depcodigo;
	
	@Column(name = "depnome")
	@Size(max=50)
	private String depnome;

	public Long getDepcodigo() {
		return depcodigo;
	}

	public void setDepcodigo(Long depcodigo) {
		this.depcodigo = depcodigo;
	}

	public String getDepnome() {
		return depnome;
	}

	public void setDepnome(String depnome) {
		this.depnome = depnome;
	}
	
}
