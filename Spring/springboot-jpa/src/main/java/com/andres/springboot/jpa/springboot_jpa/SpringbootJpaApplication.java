package com.andres.springboot.jpa.springboot_jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andres.springboot.jpa.springboot_jpa.entities.Person;
import com.andres.springboot.jpa.springboot_jpa.respositories.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Autowired
	private  PersonRepository repository;

	//es como una aplicacion de consola de sprinboot
	@Override
	public void run(String... args) throws Exception {
		

		//METODOS TRAIDOS DE LA INTERFACE

		//List<Person>persons=(List<Person>) repository.findAll();

		List<Person> persons= repository.buscarByProgrammingLanguage("Java","Andres");
		persons.stream().forEach(person -> System.out.println(person));

	}

}
