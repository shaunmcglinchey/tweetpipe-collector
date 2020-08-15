package com.clearpath;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class TweetProducer {

    private static final int SENDING_MESSAGE_TIMEOUT_MS = 10000;

    private final Source source;

    public TweetProducer(Source source) {
        this.source = source;
    }

    public void sendTweet(TwitterStatusReceived statusReceived) {
        source.output().send(
                MessageBuilder.withPayload(new Tweet(statusReceived.getStatus().getText())).build(),
                        SENDING_MESSAGE_TIMEOUT_MS);
    }
}
