package com.andres.springboot.jpa.springboot_jpa_relationship;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.andres.springboot.jpa.springboot_jpa_relationship.entities.Address;
import com.andres.springboot.jpa.springboot_jpa_relationship.entities.Client;
import com.andres.springboot.jpa.springboot_jpa_relationship.entities.Invoice;
import com.andres.springboot.jpa.springboot_jpa_relationship.repositories.ClientRepository;
import com.andres.springboot.jpa.springboot_jpa_relationship.repositories.InvoiceRepository;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
	}


	@Autowired
	private  ClientRepository clientRepository;
	@Autowired
	private InvoiceRepository invoiceRepository;




	@Override
	public void run(String... args) throws Exception {
		//manyToOne();
		//oneToManyFindById();
		deleteAdress();
	}



	@Transactional
	public void deleteAdress(){
		Client client =  new Client("Frank","Moras");
		Address address1 = new Address("El vergel",1234);
		Address address2 = new Address("Vasco de Gama",2342);

		client.getAddressList().add(address1);
		client.getAddressList().add(address2);

		clientRepository.save(client);
		System.out.println(client);

		Optional<Client>optionalCl= clientRepository.findById(3L);
		optionalCl.ifPresent(c ->{
		c.getAddressList().remove(address1);
		clientRepository.save(c);
		System.out.println(c);
		});
	}


		@Transactional
	public void oneToManyFindById(){
		Optional<Client>optionalClient= clientRepository.findById(2L);

		optionalClient.ifPresent(client ->{

		Address address1 = new Address("El vergel",1234);
		Address address2 = new Address("Vasco de Gama",2342);

		client.setAddressList(Arrays.asList(address1,address2));

		clientRepository.save(client);
		System.out.println(client);

		});

	
	}



	@Transactional
	public void oneToMany(){
		Client client =  new Client("Frank","Moras");
		Address address1 = new Address("El vergel",1234);
		Address address2 = new Address("Vasco de Gama",2342);

		client.getAddressList().add(address1);
		client.getAddressList().add(address2);

		clientRepository.save(client);
		System.out.println(client);
	}

	@Transactional
	public void manyToOne(){

		Client client= new Client("Jhon","Doe");
		clientRepository.save(client);

		Invoice invoice= new Invoice("compras de oficina ", 2000L);
		invoice.setClient(client);


		Invoice invoiceDB = invoiceRepository.save(invoice);
		System.out.println(invoiceDB);
	}

	@Transactional
	public void manyOneindIdC(){

		Optional<Client> clientOpt= clientRepository.findById(1L);
		if (clientOpt.isPresent()) {
			Client  client= clientOpt.orElseThrow();
				Invoice invoice= new Invoice("compras de oficina ", 2000L);
				invoice.setClient(client);
				Invoice invoiceDB = invoiceRepository.save(invoice);
				System.out.println(invoiceDB);
			
		}
	

	

	}



}
