package com.clearpath;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import twitter4j.Status;

@Getter
public class TwitterStatusReceived extends ApplicationEvent {

    private final Status status;

    public TwitterStatusReceived(Object source, Status status) {
        super(source);
        this.status = status;
    }

    @Override
    public String toString() {
        return "TwitterStatusReceived{" +
                "status=" + status +
                '}';
    }
}
