package com.microservice.people.api.service.person;

import com.microservice.people.api.domain.person.Person;
import com.microservice.people.api.repository.mongo.person.PersonRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by lusouza on 18/06/18.
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonCacheService personCacheService;

    @Override
    @HystrixCommand(fallbackMethod = "fallbackFindById")
    public Person findById(String id) {
        return personRepository.findById(id).orElse(null);
    }

    private Person fallbackFindById(String id){
        return personCacheService.findById(id);
    }

    @Override
    public Person save(Person person) {
        person.preValidate();
        Person personSaved = personRepository.insert(person);
        personCacheService.save(personSaved);
        return personSaved;
    }

    @Override
    public void delete(String id) {
        Person personToDelete = findById(id);
        personRepository.delete(personToDelete);
    }

    @Override
    public void authorize(String id) {
        Person person = findById(id);
        person.authorize();
        personRepository.save(person);
    }
}
