package com.example.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.model.Pessoa;
import com.example.spring.repository.PessoaRepository;

@Service("pessoaService")
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;

	@Override
	public Pessoa getPessoaById(long id) {
		return pessoaRepository.findOne(id);
	}

	@Override
	public List<Pessoa> listarTodasPessoas() {
		return pessoaRepository.findAll();
	}

}
