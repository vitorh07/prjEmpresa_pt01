package com.vitor.prjEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitor.prjEmpresa.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
