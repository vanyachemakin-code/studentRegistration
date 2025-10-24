package com.example.StudentRegistration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private final UUID id = UUID.randomUUID();
    private String firstName;
    private String secondName;
    private String age;
}
