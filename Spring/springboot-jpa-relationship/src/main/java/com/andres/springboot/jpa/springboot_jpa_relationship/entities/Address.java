package com.andres.springboot.jpa.springboot_jpa_relationship.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String street;
    private Integer number;


    public Address(long id, String street, Integer number) {
        this.id = id;
        this.street = street;
        this.number = number;
    }


    public Address() {

    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getStreet() {
        return street;
    }


    public void setStreet(String street) {
        this.street = street;
    }


    public Integer getNumber() {
        return number;
    }


    public void setNumber(Integer number) {
        this.number = number;
    }

    

    @Override
    public String toString() {
        return "Address [id=" + id + ", street=" + street + ", number=" + number + "]";
    }

    
    
    

    



}
