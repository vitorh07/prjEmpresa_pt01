package com.vitor.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitor.prjEmpresa.entities.Departamento;
import com.vitor.prjEmpresa.repositories.DepartamentoRepository;

@Service
public class DepartamentoServices {
	
	private final DepartamentoRepository departamentoRepository;
	
	@Autowired
	public DepartamentoServices(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}
	
	public Departamento findDepartamentoById(Long depcodigo) {
		Optional<Departamento> Departamento = departamentoRepository.findById(depcodigo);
		return Departamento.orElse(null);
	}
	
	public List<Departamento> findAllDepartamento() {
		return departamentoRepository.findAll();
	}
	
	public Departamento insertDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
	
	public Departamento updateDepartamento(Long depcodigo, Departamento novoDepartamento) {
		Optional<Departamento> departamentoOptional = departamentoRepository.findById(depcodigo);
		if (departamentoOptional.isPresent()) {
			Departamento departamentoExistente = departamentoOptional.get();
			departamentoExistente.setDepnome(novoDepartamento.getDepnome());
			return departamentoRepository.save(departamentoExistente);
		} else {
			return null;
		}
	}
	
	public boolean deleteDepartamento(Long depcodigo) {
		Optional<Departamento> departamentoExistente = departamentoRepository.findById(depcodigo);
		if (departamentoExistente.isPresent()) {
			departamentoRepository.deleteById(depcodigo);
			return true;
		} else {
			return false;
		}
	}
}
