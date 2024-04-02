package ru.lukyanov.kafkaproject.consumer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class Consumer{

    public static void main(String[] args) {
        SpringApplication.run(Consumer.class, args);
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("demo-topic")
                .partitions(10)
                .replicas(2)
                .build();
    }

    @KafkaListener(id = "myConsumerId", topics = "demo-topic")
    public void listen(String messageIn) {
        System.out.println(messageIn);
    }

}
