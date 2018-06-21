package com.microservice.people.api.queue.person;

import com.microservice.people.api.service.person.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by lusouza on 20/06/18.
 */
@Component
public class PersonAuthorizationProcessor {

    @Autowired
    private PersonService personService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonAuthorizationProcessor.class);

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(PersonQueueConfiguration.QUEUE_AUTHORIZE),
                    exchange = @Exchange(PersonQueueConfiguration.EXCHANGER)
            ))
    public void processMessage(org.springframework.amqp.core.Message message, @Payload String id){
        LOGGER.info(String.format("Processing authorization for personId: %s", id));
        personService.authorize(id);
    }
}
