package com.clearpath;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TwitterStatusHandler implements ApplicationListener<TwitterStatusReceived> {

    private final Sender sender;

    private ObjectMapper mapper = new ObjectMapper();

    public TwitterStatusHandler(Sender sender) {
        this.sender = sender;
    }

    @Override
    public void onApplicationEvent(TwitterStatusReceived twitterStatusReceived) {
        log.info("Received new status: {}", twitterStatusReceived);
        try {
            this.sender.sendMessage(mapper.writeValueAsString(twitterStatusReceived.getStatus().getText()));
        } catch (JsonProcessingException e) {
            log.error("Error mapping status payload");
        }
    }
}
