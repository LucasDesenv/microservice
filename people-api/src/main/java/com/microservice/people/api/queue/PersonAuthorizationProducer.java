package com.microservice.people.api.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by lusouza on 19/06/18.
 */
@Component
public class PersonAuthorizationProducer {
    private static final Logger LOG = LoggerFactory.getLogger(PersonAuthorizationProducer.class);
    @Value("${app.topic.person.authorize}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    PersonAuthorizationProducer(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String personId) {
        LOG.info("Sending message to topic " + topic);
        kafkaTemplate.send(topic, personId);
    }
}
