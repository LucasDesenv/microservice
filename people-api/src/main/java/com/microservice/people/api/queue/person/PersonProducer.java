package com.microservice.people.api.queue.person;

import com.microservice.people.api.queue.person.cache.PersonCacheData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static com.microservice.people.api.queue.person.PersonQueueConfiguration.*;

/**
 * Created by lusouza on 20/06/18.
 */
@Component
public class PersonProducer {

    private final RabbitTemplate rabbitTemplate;

    PersonProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }


    public void postForAuthorization(String id){
        rabbitTemplate.convertAndSend(EXCHANGER, QUEUE_AUTHORIZE, id);
    }

    public void postForCache(PersonCacheData personCacheData){
        rabbitTemplate.convertAndSend(EXCHANGER, QUEUE_CACHE, personCacheData);
    }
}
