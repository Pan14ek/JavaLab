package ua.nure.makieiev.labs.service;

import ua.nure.makieiev.labs.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Optional<Person> findById(long id);

    List<Person> findAll();

    Person create(Person person);

    Person update(Person person);

    boolean delete(long id);

}