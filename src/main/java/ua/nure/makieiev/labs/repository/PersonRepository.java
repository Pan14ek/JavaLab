package ua.nure.makieiev.labs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.nure.makieiev.labs.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}