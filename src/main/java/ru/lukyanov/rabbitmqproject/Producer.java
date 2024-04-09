package ru.lukyanov.rabbitmqproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier("string-data-queue")
    private Queue stringQueue;

    @Autowired
    @Qualifier("json-data-queue")
    private Queue jsonQueue;

    public void send(String message) {
        rabbitTemplate.convertAndSend(stringQueue.getName(), message);
    }

    @SneakyThrows
    public void send(Object message) {
        String json = mapper.writeValueAsString(message);
        rabbitTemplate.convertAndSend(jsonQueue.getName(), json);
    }
}
