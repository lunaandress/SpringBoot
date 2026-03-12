package com.andres.springboot.jpa.springboot_jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // le digo que  va ser una entidad 
@Table(name="persons")// pongo nombre de mi entidad (tabla) para hacer la consulta
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//esto dice crea le id  automaticamente en aunto incremental
    private long id ;
    private  String name;
    private String lastname;

    @Column(name="programing_lenguaje")
    private String programinglenguaje;

    //CONSTRUCTOR
    // En Jpa siempre hay que construir un constructor vacio  ya que es el que va a pillar

    public Person() {

    }

     //CONSTRUCTOR

    public Person(long id, String name, String lastname, String programinglenguaje) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.programinglenguaje = programinglenguaje;
    }


    //GET AND SET
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPrograminglenguaje() {
        return programinglenguaje;
    }
    public void setPrograminglenguaje(String programinglenguaje) {
        this.programinglenguaje = programinglenguaje;
    }

    //muestra los datos del objeto persona 
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", lastname=" + lastname + ", programinglenguaje="
                + programinglenguaje + "]";
    }

    
    

}
