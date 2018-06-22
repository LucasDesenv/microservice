package com.microservice.people.api.queue.person.cache;


import com.microservice.people.api.service.person.PersonCacheService;

import java.io.Serializable;

/**
 * Created by lusouza on 21/06/18.
 */
public class PersonCacheData implements Serializable{
    private String id;
    private PersonCacheOperation cacheOperation;

    public PersonCacheData(){

    }

    public PersonCacheData(String id, PersonCacheOperation cacheOperation) {
        this.id = id;
        this.cacheOperation = cacheOperation;
    }

    public String getId() {
        return id;
    }

    public PersonCacheOperation getCacheOperation() {
        return cacheOperation;
    }

    void executeOperation(final PersonCacheService personCacheService){
        cacheOperation.doOperation(this.id, personCacheService);
    }

    @Override
    public String toString() {
        return "PersonCacheData{" +
                "id='" + id + '\'' +
                ", cacheOperation=" + cacheOperation +
                '}';
    }

    public static PersonCacheData forInsert(String id) {
        return new PersonCacheData(id, PersonCacheOperation.INSERT);
    }

    public static PersonCacheData forDelete(String id) {
        return new PersonCacheData(id, PersonCacheOperation.DELETE);
    }
}
