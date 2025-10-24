package com.example.StudentRegistration.events;

import com.example.StudentRegistration.Student;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class StudentEventListener {

    @EventListener
    public void createEvent(CreateStudentEvent event) {
        Student student = event.getStudent();
        System.out.println(MessageFormat.format(
                "Добавлен студент {0} {1}", student.getFirstName(), student.getSecondName()
        ));
    }

    @EventListener
    public void deleteEvent(DeleteStudentEvent event) {
        Student student = event.getStudent();
        System.out.println(MessageFormat.format(
                "Студент с id {0} был удален!", student.getId()
        ));
    }

    @EventListener
    public void deleteAllEvent(DeleteAllStudentsEvent event) {
        System.out.println("Список студентов был очищен!");
    }

    @EventListener
    public void createDefaultList(CreateDefaultListEvent event) {
        System.out.println("Произвольный список студентов был добавлен!");
    }
}
