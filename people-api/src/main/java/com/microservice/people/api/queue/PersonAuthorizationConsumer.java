package com.microservice.people.api.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


/**
 * Created by lusouza on 19/06/18.
 */
@Component
public class PersonAuthorizationConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonAuthorizationConsumer.class);

    @KafkaListener(topics = "${app.topic.person.authorize}")
    public void processMessage(@Payload String message, @Headers MessageHeaders headers){
        LOGGER.info("Message received: " + message);
    }
}
