package com.vitor.prjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitor.prjEmpresa.entities.Departamento;
import com.vitor.prjEmpresa.services.DepartamentoServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Departamento", description = "API REST DE GERENCIAMNETO DE DEPARTAMENTO")
@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

	private final DepartamentoServices departamentoServices;
	
	@Autowired
	public DepartamentoController(DepartamentoServices departamentoServices) {
		this.departamentoServices = departamentoServices;
	}
	
	@GetMapping("/{depcodigo}")
	@Operation(summary = "Localiza departamento por ID")
	public ResponseEntity<Departamento> findDepartamentobyId(@PathVariable Long depcodigo) {
		Departamento departamento = departamentoServices.findDepartamentoById(depcodigo);
		if (departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/")
	@Operation(summary = "Apresenta todos o departamento ")
	public ResponseEntity<List<Departamento>> findAllDepartamentoControl(){
		List<Departamento> departamento = departamentoServices.findAllDepartamento();
		return ResponseEntity.ok(departamento);
	}

	@PostMapping("/")
	@Operation(summary = "Cadastra um departamento")
	public ResponseEntity<Departamento> insertDepartamentoControl(@RequestBody @Valid Departamento departamento) {
		Departamento novoDepartamento = departamentoServices.insertDepartamento(departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoDepartamento);
	}

	@PutMapping("/depcodigo")
	@Operation(summary = "Altera um departamento")
	public ResponseEntity<Departamento> updateDepartamentoControl(@PathVariable Long depcodigo, @RequestBody @Valid Departamento departamento) {
		Departamento mudadepartamento = departamentoServices.updateDepartamento(depcodigo, departamento);
		if (mudadepartamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/depcodigo")
	@Operation(summary = "Exclui um departamento")
	public ResponseEntity<String> deleteDepartamentoControl(@PathVariable Long depcodigo) {
		boolean remover = departamentoServices.deleteDepartamento(depcodigo);
		if (remover) {
			return ResponseEntity.ok().body("Departamento Excludepcodigoo com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
