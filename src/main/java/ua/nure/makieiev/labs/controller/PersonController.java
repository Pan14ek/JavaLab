package ua.nure.makieiev.labs.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.nure.makieiev.labs.dto.PersonDto;
import ua.nure.makieiev.labs.entity.Company;
import ua.nure.makieiev.labs.entity.Person;
import ua.nure.makieiev.labs.exception.NotFoundPersonException;
import ua.nure.makieiev.labs.service.CompanyService;
import ua.nure.makieiev.labs.service.PersonService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final CompanyService companyService;
    private final ModelMapper modelMapper;

    @Autowired
    public PersonController(PersonService personService, CompanyService companyService, ModelMapper modelMapper) {
        this.personService = personService;
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/allusers")
    public String showAllUsers(Model model) {
        model.addAttribute("users", personService.findAll());
        return "user-list";
    }

    @GetMapping("/signup")
    public String showSignUpForm(PersonDto personDto) {
        return "add-user";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Person person = personService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("personDto", person);
        return "update-user";
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
    public String addPerson(@Valid PersonDto personDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        Optional<Company> companyOptional = companyService.findById(1);
        if (companyOptional.isPresent()) {
            Person person = modelMapper.map(personDto, Person.class);
            person.setCompany(companyOptional.get());
            personService.create(person);
        }
        model.addAttribute("users", personService.findAll());
        return "user-list";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") long id, @Valid PersonDto personDto,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            personDto.setId(id);
            return "update-user";
        }
        Person person = modelMapper.map(personDto, Person.class);
        personService.update(person);
        model.addAttribute("users", personService.findAll());
        return "user-list";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable long id, Model model) {
        personService.delete(id);
        model.addAttribute("users", personService.findAll());
        return "user-list";
    }

}