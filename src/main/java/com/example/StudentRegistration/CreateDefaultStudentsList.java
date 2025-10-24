package com.example.StudentRegistration;

import com.example.StudentRegistration.events.CreateDefaultListEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
@ConditionalOnProperty("app.create-students-on-startup")
@RequiredArgsConstructor
public class CreateDefaultStudentsList {

    private final ApplicationEventPublisher publisher;
    public static Map<String, Student> defaultStudentList = new HashMap<>();

    @EventListener(ContextRefreshedEvent.class)
    public void createStudentList() {
        for (int i = 1; i <= 10; i++) {
            Student student = new Student(
                    "Kim" + i,
                    "Chin" + i,
                    String.valueOf(randomAge())
            );
            defaultStudentList.put(student.getId().toString(), student);
        }
        publisher.publishEvent(new CreateDefaultListEvent(this));
    }

    private int randomAge() {
        Random random = new Random();
        int minAge = 7;
        int maxAge = 35;
        return random.nextInt(maxAge - minAge) + minAge;
    }
}
