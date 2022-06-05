package com.andersen.studentcrud.model;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    UUID id;
    private String firstName;
    private String lastName;
    private int age;



}
