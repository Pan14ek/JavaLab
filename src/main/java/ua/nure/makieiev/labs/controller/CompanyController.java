package ua.nure.makieiev.labs.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.makieiev.labs.dto.CompanyDto;
import ua.nure.makieiev.labs.entity.Company;
import ua.nure.makieiev.labs.exception.NotFoundCompanyException;
import ua.nure.makieiev.labs.service.CompanyService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final ModelMapper modelMapper;
    private final CompanyService companyService;

    @Autowired
    public CompanyController(ModelMapper modelMapper, CompanyService companyService) {
        this.modelMapper = modelMapper;
        this.companyService = companyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable long id) {
        Optional<Company> personOptional = companyService.findById(id);
        if (personOptional.isPresent()) {
            return new ResponseEntity<>(personOptional.get(), HttpStatus.OK);
        }
        throw new NotFoundCompanyException("Company did not find by id");
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCompany(@RequestBody @Valid CompanyDto companyDto, BindingResult bindingResult) {
        Company company = modelMapper.map(companyDto, Company.class);
        company = companyService.create(company);
        return company.getId() != 0 ? new ResponseEntity<>(company, HttpStatus.CREATED) : new ResponseEntity<>(bindingResult, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCompany(@RequestBody @Valid CompanyDto companyDto, BindingResult bindingResult) {
        Company company = modelMapper.map(companyDto, Company.class);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

}
