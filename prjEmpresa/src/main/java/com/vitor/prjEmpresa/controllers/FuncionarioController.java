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

import com.vitor.prjEmpresa.entities.Funcionario;
import com.vitor.prjEmpresa.services.FuncionarioServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Funcionario", description = "API REST DE GERENCIAMENTO DE FUNCIONÁRIOS")
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	private final FuncionarioServices funcionarioServices;
	
	@Autowired
	public FuncionarioController(FuncionarioServices funcionarioServices) {
		this.funcionarioServices = funcionarioServices;
	}
	
	@GetMapping("/{funcodigo}")
	@Operation(summary = "Localiza funcionario por ID")
	public ResponseEntity<Funcionario> findFuncionariobyId(@PathVariable Long funcodigo) {
		Funcionario funcionario = funcionarioServices.findFuncionarioById(funcodigo);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/")
	@Operation(summary = "Apresenta todos o funcionario ")
	public ResponseEntity<List<Funcionario>> findAllFuncionarioControl(){
		List<Funcionario> funcionario = funcionarioServices.findAllFuncionario();
		return ResponseEntity.ok(funcionario);
	}

	@PostMapping("/")
	@Operation(summary = "Cadastra um funcionario")
	public ResponseEntity<Funcionario> insertFuncionarioControl(@RequestBody @Valid Funcionario funcionario) {
		Funcionario novoFuncionario = funcionarioServices.insertFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
	}

	@PutMapping("/funcodigo")
	@Operation(summary = "Altera um departamento")
	public ResponseEntity<Funcionario> updateFuncionarioControl(@PathVariable Long funcodigo, @RequestBody @Valid Funcionario funcionario) {
		Funcionario mudafuncionario = funcionarioServices.updateFuncionario(funcodigo, funcionario);
		if (mudafuncionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/funcodigo")
	@Operation(summary = "Exclui um funcionario")
	public ResponseEntity<String> deleteFuncionarioControl(@PathVariable Long funcodigo) {
		boolean remover = funcionarioServices.deleteFuncionario(funcodigo);
		if (remover) {
			return ResponseEntity.ok().body("Funcionario Exclufuncodigoo com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
