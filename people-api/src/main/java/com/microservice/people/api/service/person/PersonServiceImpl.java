package com.microservice.people.api.service.person;

import com.microservice.people.api.domain.person.Person;
import com.microservice.people.api.repository.mongo.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lusouza on 18/06/18.
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findById(String id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person save(Person person) {
        person.preValidate();
        return personRepository.save(person);
    }

    @Override
    public void delete(String id) {
        Person perosnToDelete = findById(id);
        personRepository.delete(perosnToDelete);
    }
}
