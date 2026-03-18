package com.andres.springboot.jpa.springboot_jpa_relationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andres.springboot.jpa.springboot_jpa_relationship.entities.Invocie;

public interface InvoiceRepository  extends CrudRepository<Invocie,Long>{

}
