package com.example.StudentRegistration.events;

import org.springframework.context.ApplicationEvent;

public class CreateDefaultListEvent extends ApplicationEvent {

    public CreateDefaultListEvent(Object source) {
        super(source);
    }
}
