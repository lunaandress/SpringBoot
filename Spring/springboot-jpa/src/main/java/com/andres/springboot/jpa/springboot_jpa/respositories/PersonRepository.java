package com.andres.springboot.jpa.springboot_jpa.respositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.andres.springboot.jpa.springboot_jpa.dto.PersonDto;
import com.andres.springboot.jpa.springboot_jpa.entities.Person;

// rudRepository<Person,Long> Te da automáticamente operaciones CRUD:
//<Person, Long>  es la : <Entity, idEntity>
public interface PersonRepository  extends CrudRepository<Person,Long> {


    //METODOS


    @Query("select distinct p.name from Person p")
    List<String> findAllNames();

    // este metodo me  crea  un nuevo objeto  y me muestra al informacion  pero con los variables de DTO
    @Query("select new  com.andres.springboot.jpa.springboot_jpa.dto.PersonDto (p.name , p.lastname ) from  Person p ")
    List<PersonDto>findAllPersonDto();
    @Query("select  p  ,  p.programmingLanguage from Person p")
    List<Object[]>findAllMixPerson(); 
    @Query("select p.name from Person p where p.id=?1")
    String getNameById(long id);
    @Query("select p from Person p where p.id=?1")
    Optional<Person> findOne(long id);
    @Query("select p from Person p where p.name=?1")
    Optional<Person> findOneName(String name);
    //Si quiero crear un metodo  nuevo que no este en Crud  tengo que hacer esto :
    @Query("select p from  Person  p where p.programmingLanguage=?1 and p.name=?2")// se usa el nombre de la clase importante
    List<Person> buscarByProgrammingLanguage(String programmingLanguage, String name);
    List<Person> findByProgrammingLanguage(String programmingLanguage);
    @Query("select p.name , p.programmingLanguage from Person p")
    List<Object[]>obtenerPersonaData();
}




