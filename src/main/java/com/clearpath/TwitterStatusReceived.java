package com.clearpath;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;
import twitter4j.Status;

@Getter
@ToString
public class TwitterStatusReceived extends ApplicationEvent {

    private final Status status;

    public TwitterStatusReceived(Object source, Status status) {
        super(source);
        this.status = status;
    }
}
