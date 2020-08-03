package com.clearpath;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TwitterStatusHandler implements ApplicationListener<TwitterStatusReceived> {

    private final TweetProducer tweetProducer;

    public TwitterStatusHandler(TweetProducer tweetProducer) {
        this.tweetProducer = tweetProducer;
    }

    @Override
    public void onApplicationEvent(TwitterStatusReceived twitterStatusReceived) {
        log.info("Received new status: {}", twitterStatusReceived);
        this.tweetProducer.sendTweet(twitterStatusReceived);
    }
}
