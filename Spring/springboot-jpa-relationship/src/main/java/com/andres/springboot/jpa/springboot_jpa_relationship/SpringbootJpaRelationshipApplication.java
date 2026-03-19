package com.andres.springboot.jpa.springboot_jpa_relationship;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

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
		manyToOne();
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
