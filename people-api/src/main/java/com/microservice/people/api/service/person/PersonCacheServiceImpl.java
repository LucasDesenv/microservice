package com.microservice.people.api.service.person;

import com.microservice.people.api.domain.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by lusouza on 20/06/18.
 */
@Service
public class PersonCacheServiceImpl implements PersonCacheService {
    private static final String KEY = "person";
    private final RedisTemplate<String, Person> redisTemplate;
    private HashOperations<String, String, Person> hashOps;
    private final PersonService personService;

    @Autowired
    public PersonCacheServiceImpl(RedisTemplate redisTemplate, PersonService personService) {
        this.redisTemplate = redisTemplate;
        this.personService = personService;
    }

    @PostConstruct
    private void init() {
        hashOps = redisTemplate.opsForHash();
    }

    @Override
    public Person findById(String id) {
        return hashOps.get(KEY, id);
    }

    @Override
    public void save(String id) {
        final Person person = personService.findById(id);
        hashOps.put(KEY, person.getId() , person);
    }

    @Override
    public void delete(String id) {
        hashOps.delete(KEY, id);
    }

    @Override
    public void update(String id) {
        this.save(id);
    }

}
