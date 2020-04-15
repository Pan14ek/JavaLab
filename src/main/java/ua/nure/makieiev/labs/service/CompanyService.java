package ua.nure.makieiev.labs.service;

import ua.nure.makieiev.labs.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    List<Company> findAll();

    Optional<Company> findById(long id);

    Company create(Company company);

}