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
    public static final String QUEUE_AUTHORIZE = "authorize";
    public static final String QUEUE_CACHE = "cache";
    public static final String EXCHANGER = "person_events";

    @Bean
    Queue authorize(){
        return new Queue(QUEUE_AUTHORIZE, true);
    }

    @Bean
    Queue cache(){
        return new Queue(QUEUE_CACHE, true);
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
    Binding bindingPeopleRead(@Qualifier("cache") Queue queue, DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(QUEUE_CACHE);
    }
}
