package com.microservice.people.api.queue.person.cache;

import com.microservice.people.api.service.person.PersonCacheService;

/**
 * Created by lusouza on 21/06/18.
 */
public enum PersonCacheOperation {
    DELETE {
        @Override
        void doOperation(String id, PersonCacheService personCacheService) {
            personCacheService.delete(id);
        }
    }, UPDATE {
        @Override
        void doOperation(String id, PersonCacheService personCacheService) {
            personCacheService.update(id);
        }
    }, INSERT {
        @Override
        void doOperation(String id, PersonCacheService personCacheService) {
            personCacheService.save(id);
        }
    };

    abstract void doOperation(String id, PersonCacheService personCacheService);
}
