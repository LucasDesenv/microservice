package com.microservice.people.api.service.person;

import com.microservice.people.api.domain.person.Person;

/**
 * Created by lusouza on 18/06/18.
 */
public interface PersonService {
    Person findById(String id);

    Person save(Person person);

    void delete(String id);
}
