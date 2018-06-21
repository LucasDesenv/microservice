package com.microservice.people.api.queue.person;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lusouza on 20/06/18.
 */
@Configuration
public class PersonQueueConfiguration {
    static final String QUEUE_AUTHORIZE = "authorize";
    static final String QUEUE_PEOPLE_READ = "read";
    static final String EXCHANGER = "person_events";

    @Bean
    Queue authorize(){
        return new Queue(QUEUE_AUTHORIZE, true);
    }

    @Bean
    Queue read(){
        return new Queue(QUEUE_PEOPLE_READ, false);
    }

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(EXCHANGER);
    }

    @Bean
    Binding bindingPeopleWrite(@Qualifier("authorize") Queue queue, DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(QUEUE_AUTHORIZE);
    }

    @Bean
    Binding bindingPeopleRead(@Qualifier("read") Queue queue, DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(QUEUE_PEOPLE_READ);
    }
}
