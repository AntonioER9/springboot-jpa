package com.andres.course.springboot.jpa.springboot_jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.andres.course.springboot.jpa.springboot_jpa.entities.Person;
import com.andres.course.springboot.jpa.springboot_jpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// List<Person> persons = (List<Person>) repository.findAll(); // findAll()
		// returns an Iterable, so we cast it to List
		// List<Person> persons = (List<Person>)
		// repository.searchByProgrammingLanguage("Java", "Andres");
		// persons.stream().forEach(person -> System.out.println(person));
		create();
	}

	@Transactional
	public void create() {

		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		String lastname = scanner.next();
		String programmingLanguage = scanner.next();
		scanner.close();

		Person person = new Person(name, lastname, programmingLanguage);
		Person personNew = repository.save(person);
		System.out.println(personNew);

		repository.findById(personNew.getId()).ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findOne() {

		Person person = null;
		Optional<Person> optionalPerson = repository.findById(1L);
		if (optionalPerson.isPresent()) {
			person = optionalPerson.get();
		}
		System.out.println(person);
		// repository.findOneName("Andres").ifPresent(person ->
		// System.out.println(person));
		repository.findOneName("Andres").ifPresent(System.out::println);
	}

}
