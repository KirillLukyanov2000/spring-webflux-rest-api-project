package ru.lukyanov.rabbitmqproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = "string-data")
    public void receiveStringData(String message) {
        log.info("Received string data: {}", message);
    }

    @RabbitListener(queues = "json-data")
    public void receiveJsonData(String message) {
        log.info("Received json data: {}", message);
    }
}
