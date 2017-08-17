package com.example.spring.SpringExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.spring.model.Pessoa;
import com.example.spring.repository.PessoaRepository;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.spring")
@EnableJpaRepositories(basePackages = "com.example.spring.repository")
@EntityScan(basePackages = "com.example.spring.model")
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**Inicializa o app adicionando alguns dados na tabela Pessoa*/
	@Bean
	public CommandLineRunner setup(PessoaRepository pessoaRepository) {
		return (args) -> {
			pessoaRepository.save(new Pessoa("Diego", "Augusto"));
			pessoaRepository.save(new Pessoa("Crislayne", "Durante"));
			pessoaRepository.save(new Pessoa("Kelao ", "Pereirao"));
			pessoaRepository.save(new Pessoa("Rodrigo", "Cavacao"));
			logger.info("As Pessoas foram geradas");
		};
	}

}
