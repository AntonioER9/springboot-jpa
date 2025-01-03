package com.andres.course.springboot.jpa.springboot_jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.andres.course.springboot.jpa.springboot_jpa.entities.Person;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

  List<Person> findByProgrammingLanguage(String programmingLanguage);

  @Query("SELECT p FROM Person p WHERE p.programmingLanguage = ?1 and p.name = ?2")
  List<Person> searchByProgrammingLanguage(String programmingLanguage, String name);

  List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);
}
