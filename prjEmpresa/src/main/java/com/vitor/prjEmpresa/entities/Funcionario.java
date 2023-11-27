package com.vitor.prjEmpresa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long funcodigo;
	
	@Column(name = "funnome")
	@Size(max=100)
	private String funnome;
	
	@Column(name = "funnascimento")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate funnascimento;
	
	@Column(name = "funsalario")
	private double funsalario;

	public Long getFuncodigo() {
		return funcodigo;
	}

	public void setFuncodigo(Long funcodigo) {
		this.funcodigo = funcodigo;
	}

	public String getFunnome() {
		return funnome;
	}

	public void setFunnome(String funnome) {
		this.funnome = funnome;
	}

	public LocalDate getFunnascimento() {
		return funnascimento;
	}

	public void setFunnascimento(LocalDate funnascimento) {
		this.funnascimento = funnascimento;
	}

	public double getFunsalario() {
		return funsalario;
	}

	public void setFunsalario(double funsalario) {
		this.funsalario = funsalario;
	}
}