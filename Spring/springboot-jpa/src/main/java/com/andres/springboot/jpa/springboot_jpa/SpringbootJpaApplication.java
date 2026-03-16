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

	@Override
	public void run(String... args) throws Exception {

		findOne();

	}


	public void  findOne(){
		//Person  person = null;
		//Optional <Person> optionalPerson=repository.findById(10l);
		//if (optionalPerson.isPresent()) {
		//	person=optionalPerson.get();
		//}else{
		//	System.out.println("no esta presente ");
		//}
		// System.err.println(person);



		repository.findById(1L).ifPresent(System.out::println);
		repository.findOne(1L).ifPresent(System.out::println);
		repository.findOneName("Pepe").ifPresent(System.out::println);
		
		

	}


	// meto los metodos en otro metodo  void
public  void list(){
	//METODOS TRAIDOS DE LA INTERFACE
		//List<Person>persons=(List<Person>) repository.findAll();
		List<Person> persons= repository.buscarByProgrammingLanguage("Java","Andres");
		persons.stream().forEach(person -> System.out.println(person));

		////////////////////////////////////////////////////////////////
		
		//mostramos los  datos de personas por valores
		List<Object[]> personsValues= repository.obtenerPersonaData();
		personsValues.stream().forEach( person ->{
				System.out.println( person[0]+" es experto en " + person[1]);
		});

}

}
