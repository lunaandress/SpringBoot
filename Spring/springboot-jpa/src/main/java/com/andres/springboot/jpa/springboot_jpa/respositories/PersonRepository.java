package com.andres.springboot.jpa.springboot_jpa.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.andres.springboot.jpa.springboot_jpa.entities.Person;

// rudRepository<Person,Long> Te da automáticamente operaciones CRUD:
//<Person, Long>  es la : <Entity, idEntity>
public interface PersonRepository  extends CrudRepository<Person,Long> {


    //Si quiero crear un metodo  nuevo que no este en Crud  tengo que hacer esto :
    @Query("select p from  Person  p where p.programmingLanguage=?1 and p.name=?2")// se usa el nombre de la clase importante
    List<Person> buscarByProgrammingLanguage(String programmingLanguage, String name);
    
    List<Person> findByProgrammingLanguage(String programmingLanguage);

    @Query("select p.name , p.programmingLanguage from Person p")
    List<Object[]>obtenerPersonaData();
}


