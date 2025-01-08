package com.andres.course.springboot.jpa.springboot_jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.andres.course.springboot.jpa.springboot_jpa.entities.Person;
import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

  @Query("SELECT p.name FROM Person p WHERE p.id = ?1")
  String getNameById(Long id);

  @Query("SELECT p p.programmingLanguage FROM Person p")
  List<Object[]> findAllMixPerson();

  @Query("SELECT p FROM Person p WHERE p.id = ?1")
  Optional<Person> findOne(Long id);

  @Query("SELECT p FROM Person p WHERE p.name = ?1")
  Optional<Person> findOneName(String name);

  List<Person> findByProgrammingLanguage(String programmingLanguage);

  @Query("SELECT p FROM Person p WHERE p.programmingLanguage = ?1 and p.name = ?2")
  List<Person> searchByProgrammingLanguage(String programmingLanguage, String name);

  List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);

  Optional<Person> findByNameContaining(String name);
}
