package com.clearpath;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Sender {

    private KafkaTemplate<String, String> kafkaTemplate;

    private final String topic;

    public Sender(
            KafkaTemplate<String, String> kafkaTemplate,
            @Value("${kafka.topic}") String topic
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void sendMessage(String message) {
        log.debug("Sending message payload: {}", message);
        this.kafkaTemplate.send(topic, message);
    }
}
