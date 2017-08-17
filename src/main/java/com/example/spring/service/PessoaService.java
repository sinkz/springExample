package com.example.spring.service;

import java.util.List;

import com.example.spring.model.Pessoa;

public interface PessoaService {

	Pessoa getPessoaById(long id);
	List<Pessoa> listarTodasPessoas();
}
