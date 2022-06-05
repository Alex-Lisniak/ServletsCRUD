package com.andersen.sttudentcrud.dao;

import com.andersen.studentcrud.dao.StudentDAO;
import com.andersen.studentcrud.model.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentDAOTest {

    StudentDAO studentDAO = new StudentDAO();

    @Test
    public void addDepartmentTest() {
        assertTrue(studentDAO.add("Richard", "Feynman", 23));
    }

    @Test
    public void getAllTest() {
        studentDAO.add("Henrich", "Hertz",25);
        studentDAO.add("James", "Maxwell", 23);
        studentDAO.add("Nicolai", "Popov", 34);
        List <Student> students = studentDAO.getAll();
        assertEquals(students.get(0).getFirstName(), "Henrich");
    }

}
