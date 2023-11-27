package com.vitor.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitor.prjEmpresa.entities.Funcionario;
import com.vitor.prjEmpresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioServices {
	
		private final FuncionarioRepository funcionarioRepository;
		
		@Autowired
		public FuncionarioServices(FuncionarioRepository funcionarioRepository) {
			this.funcionarioRepository = funcionarioRepository;
		}
		
		public Funcionario findFuncionarioById(Long funcodigo) {
			Optional<Funcionario> Funcionario = funcionarioRepository.findById(funcodigo);
			return Funcionario.orElse(null);
		}
		
		public List<Funcionario> findAllFuncionario() {
			return funcionarioRepository.findAll();
		}
		
		public Funcionario insertFuncionario(Funcionario funcionario) {
			return funcionarioRepository.save(funcionario);
		}
		
		public Funcionario updateFuncionario(Long funcodigo, Funcionario novoFuncionario) {
			Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(funcodigo);
			if (funcionarioOptional.isPresent()) {
				Funcionario funcionarioExistente = funcionarioOptional.get();
				funcionarioExistente.setFunnome(novoFuncionario.getFunnome());
				funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());
				funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());
				return funcionarioRepository.save(funcionarioExistente);
			} else {
				return null;
			}
		}
		
		public boolean deleteFuncionario(Long funcodigo) {
			Optional<Funcionario> funcionarioExistente = funcionarioRepository.findById(funcodigo);
			if (funcionarioExistente.isPresent()) {
				funcionarioRepository.deleteById(funcodigo);
				return true;
			} else {
				return false;
			}
		}
}
