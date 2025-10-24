package com.example.StudentRegistration;

import com.example.StudentRegistration.events.CreateStudentEvent;
import com.example.StudentRegistration.events.DeleteAllStudentsEvent;
import com.example.StudentRegistration.events.DeleteStudentEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.command.annotation.Command;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

@Component
@Command
@RequiredArgsConstructor
public class StudentService {

    private final ApplicationEventPublisher publisher;
    private Map<String, Student> students = new HashMap<>();

    @Command(command = "getAll", description = "Выводит всех студентов.")
    public void getAllStudents() {
        if (!students.isEmpty() | !CreateDefaultStudentsList.defaultStudentList.isEmpty()) {
            students.values().forEach(System.out::println);
            CreateDefaultStudentsList.defaultStudentList.values().forEach(System.out::println);
        } else throw new RuntimeException("Список студентов пуст!");
    }

    @Command(command = "add", description = "Добавляет студента. Пример ввода: Имя Фамилия Возраст")
    public void addStudent(String firstName, String secondName, String age) {
        Student student = new Student(firstName, secondName, age);
        students.put(student.getId().toString(), student);
        publisher.publishEvent(new CreateStudentEvent(this, student));
    }

    @Command(command = "delete", description = "Удаляет студента по его id.")
    public void deleteById(String id) {
        if (!students.containsKey(id)) {
            throw new RuntimeException(MessageFormat.format("Студент с id ({0}) не найден", id));
        }
        students.remove(id);
        publisher.publishEvent(new DeleteStudentEvent(this, students.get(id)));
    }

    @Command(command = "deleteAll", description = "Очищает список студентов.")
    public void deleteAll() {
        students = new HashMap<>();
        CreateDefaultStudentsList.defaultStudentList = new HashMap<>();
        publisher.publishEvent(new DeleteAllStudentsEvent(this));
    }
}
