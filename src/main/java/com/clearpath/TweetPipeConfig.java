package com.clearpath;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import javax.annotation.PostConstruct;

@Configuration
public class TweetPipeConfig {

    private TwitterListener twitterListener;
    private String[] queryTerms;
    private String[] queryLanguages;

    public TweetPipeConfig(TwitterListener twitterListener,
                           @Value("${kafka.track.query.terms}") String[] queryTerms,
                           @Value("${kafka.track.query.languages}") String[] queryLanguages) {
        this.twitterListener = twitterListener;
        this.queryTerms = queryTerms;
        this.queryLanguages = queryLanguages;
    }

    @PostConstruct
    public void initTwitterStream() {
        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
        FilterQuery tweetQuery = new FilterQuery();
        tweetQuery.track(queryTerms);
        tweetQuery.language(queryLanguages);
        twitterStream.addListener(twitterListener);
        twitterStream.filter(tweetQuery);
    }
}
