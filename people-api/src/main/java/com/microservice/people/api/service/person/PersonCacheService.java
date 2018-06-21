package com.microservice.people.api.service.person;

import com.microservice.people.api.domain.person.Person;

/**
 * Created by lusouza on 20/06/18.
 */
public interface PersonCacheService {
    Person findById(String id);
    void save(Person person);
    void delete(String id);

}
