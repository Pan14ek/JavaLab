package ua.nure.makieiev.labs.service.impl;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.makieiev.labs.entity.Person;
import ua.nure.makieiev.labs.repository.PersonRepository;
import ua.nure.makieiev.labs.service.PersonService;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Person> findById(long id) {
        return personRepository.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return IterableUtils.toList(personRepository.findAll());
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public boolean delete(long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            personRepository.delete(person.get());
            return true;
        }
        return false;
    }

}