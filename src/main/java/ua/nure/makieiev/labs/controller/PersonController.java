package ua.nure.makieiev.labs.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.makieiev.labs.dto.PersonDto;
import ua.nure.makieiev.labs.entity.Person;
import ua.nure.makieiev.labs.exception.NotFoundPersonException;
import ua.nure.makieiev.labs.service.PersonService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;
    private ModelMapper modelMapper;

    @Autowired
    public PersonController(PersonService personService, ModelMapper modelMapper) {
        this.personService = personService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable long id) {
        Optional<Person> personOptional = personService.findById(id);
        if (personOptional.isPresent()) {
            return new ResponseEntity<>(personOptional.get(), HttpStatus.OK);
        }
        throw new NotFoundPersonException("User did not find by id");
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPerson(@RequestBody @Valid PersonDto personDto, BindingResult bindingResult) {
        Person person = modelMapper.map(personDto, Person.class);
        person = personService.create(person);
        if (person.getId() != 0) {
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(bindingResult, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody @Valid PersonDto personDto, BindingResult bindingResult) {
        Person person = modelMapper.map(personDto, Person.class);
        return new ResponseEntity<>(personService.update(person), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable long id) {
        boolean deleteFlag = personService.delete(id);
        if (deleteFlag) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        throw new NotFoundPersonException("User did not find by id");
    }

}