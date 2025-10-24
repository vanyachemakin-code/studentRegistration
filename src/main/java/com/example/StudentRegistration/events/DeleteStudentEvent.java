package com.example.StudentRegistration.events;

import com.example.StudentRegistration.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class DeleteStudentEvent extends ApplicationEvent {

    private final Student student;

    public DeleteStudentEvent(Object source, Student student) {
        super(source);
        this.student = student;
    }
}
