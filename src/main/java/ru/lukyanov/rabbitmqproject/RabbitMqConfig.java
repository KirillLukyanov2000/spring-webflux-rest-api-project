package ru.lukyanov.rabbitmqproject;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {

    public static final String STRING_QUEUE_NAME = "string-data";
    public static final String JSON_QUEUE_NAME = "json-data";

    @Bean("string-data-queue")
    Queue createQueue() {
        return new Queue(STRING_QUEUE_NAME, false);
    }

    @Bean("json-data-queue")
    Queue createQueue2() {
        return new Queue(JSON_QUEUE_NAME, false);
    }
}
