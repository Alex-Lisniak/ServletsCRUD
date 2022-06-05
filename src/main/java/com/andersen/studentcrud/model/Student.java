package com.andersen.studentcrud.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Student {
    UUID id;
    private String firstName;
    private String lastName;
    private int age;
}
