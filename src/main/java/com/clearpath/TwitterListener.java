package com.clearpath;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

@Component
@AllArgsConstructor
public class TwitterListener implements StatusListener {

    private TweetProducer tweetProducer;

    @Override
    public void onStatus(Status status) {
        tweetProducer.sendTweet(new Tweet(status.getText()));
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    @Override
    public void onTrackLimitationNotice(int i) {

    }

    @Override
    public void onScrubGeo(long l, long l1) {

    }

    @Override
    public void onStallWarning(StallWarning stallWarning) {

    }

    @Override
    public void onException(Exception e) {

    }
}
