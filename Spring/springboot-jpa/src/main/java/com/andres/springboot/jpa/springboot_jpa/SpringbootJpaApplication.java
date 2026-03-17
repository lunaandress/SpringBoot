package com.andres.springboot.jpa.springboot_jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andres.springboot.jpa.springboot_jpa.dto.PersonDto;
import com.andres.springboot.jpa.springboot_jpa.entities.Person;
import com.andres.springboot.jpa.springboot_jpa.respositories.PersonRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	static Scanner sc = new Scanner(System.in);

	@Autowired
	private  PersonRepository repository;

	@Override
	public void run(String... args) throws Exception {

		//list();

		//findOne();
		//create();
		//update();
		//delete();
		//personalizedQueries();
		//personalizeQueries2();
		personalizeQueryDistinct();

	
		




	}


	@Transactional
	public void personalizeQueryDistinct(){
			System.out.println("Imprimir consultas con nombres de personas ");
			List<String> names= repository.findAllNames();
			names.forEach(System.out::println);
		}





	@Transactional
	public void personalizeQueries2(){
		System.out.println("=======consulta por pobjeto person  y lenguje de programacion =========");
		List<Object[]> perObjects= repository.findAllMixPerson();
		perObjects.forEach(reg ->{
			System.out.println("programmingLanguage=" + reg[1] + "person= " + reg[0]);
		});

		System.out.println("consulta que puebla y devuelve una clase dto ");
		List<PersonDto> personDto= repository.findAllPersonDto();
		personDto.forEach(System.out::println);
	}


	@Transactional
	public void personalizedQueries(){
		System.out.println("=========Consulta Personalizada============");
		System.out.println("Ingrese el id para el nombre a mostrar");
		long id = sc.nextLong();
		String name = repository.getNameById(id);
		System.out.println(name);
	}

	@Transactional
	public  void delete(){
		System.out.println("Ingrese el Id a eliminar:");
		Long id = sc.nextLong();
		repository.deleteById(id);
	}

	@Transactional//  eso se usa cuando se modifica una tabla en la DB
	public void update(){
		System.out.println("ingrese el id de la persona:");
		long id = sc.nextLong();
		Optional <Person> optionalP  = repository.findById(id);
		optionalP.ifPresent(person ->{
			System.out.println("Ingrese el lenguaje de Programacion");
			String programmingLanguage= sc.next();
			person.setProgrammingLanguage(programmingLanguage);
			Person personDb =repository.save(person);
			System.out.println(personDb);
		});
	}

	public void create(){
		Scanner sc = new Scanner(System.in);
		System.out.println("INGRESE LOS DATA DEL NUEVO USUARIO ");
		String name =  sc.next();
		String lastname= sc.next();
		String programmingLanguage= sc.next();
		sc.close();

		Person person = new Person(name, lastname,programmingLanguage);
		Person personNew=repository.save(person);
		System.out.println(personNew);

		repository.findById(personNew.getId()).ifPresent(p->System.out.println(person));
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
