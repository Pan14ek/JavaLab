package ua.nure.makieiev.labs.service.impl;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.makieiev.labs.entity.Company;
import ua.nure.makieiev.labs.repository.CompanyRepository;
import ua.nure.makieiev.labs.service.CompanyService;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return IterableUtils.toList(companyRepository.findAll());
    }

    @Override
    public Optional<Company> findById(long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company create(Company company) {
        return companyRepository.save(company);
    }

}