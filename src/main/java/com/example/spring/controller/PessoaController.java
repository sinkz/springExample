package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.Pessoa;
import com.example.spring.service.PessoaService;

@RestController
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@RequestMapping(value = "/pessoa", method = RequestMethod.GET)
	public List<Pessoa> getEmployees() {
		return pessoaService.listarTodasPessoas();
	}

	@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Pessoa getEmployee(@PathVariable("id") long id) {
		return pessoaService.getPessoaById(id);
	}
}
