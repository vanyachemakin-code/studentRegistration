package com.example.StudentRegistration.events;

import org.springframework.context.ApplicationEvent;

public class DeleteAllStudentsEvent extends ApplicationEvent {

    public DeleteAllStudentsEvent(Object source) {
        super(source);
    }
}
