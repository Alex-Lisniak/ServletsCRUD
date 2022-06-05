package com.andersen.studentcrud.dao;

import com.andersen.studentcrud.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.util.List;
import java.util.UUID;

public class StudentDAO {
    String dbURL = "jdbc:mysql://localhost:5432/student_db";
    String username = "root";
    String password = "secret";

    private Connection conn;
    public static String INSERT="INSERT INTO students (first_name, last_name, age) VALUES (?, ?, ?);";
    public static String SELECT_ALL="SELECT * FROM students;";
    public static String SELECT_BY_ID="SELECT * FROM students WHERE id = ?;";
    public static String UPDATE = "UPDATE students SET first_name=?, last_name=?, age=? WHERE id=?;";

    public boolean add(String firstName, String lastName, int age) {
        try (
                Connection connection = DriverManager.getConnection(dbURL);
                PreparedStatement statement = conn.prepareStatement(INSERT)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public List <Student> getAll() {
        List<Student> students= new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(dbURL);
            PreparedStatement statement = conn.prepareStatement(SELECT_ALL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                UUID id = rs.getObject("id", java.util.UUID.class);
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                students.add(new Student(id, firstName, lastName, age));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return students;
    }
    public Student getById(UUID id) {
        Student student = new Student();
        try(Connection connection = DriverManager.getConnection(dbURL);
            PreparedStatement statement = conn.prepareStatement(SELECT_BY_ID)) {
            statement.setObject(1,id);
            ResultSet rs = statement.executeQuery();
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int age = rs.getInt("age");
            student.setId(id);
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setAge(age);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return student;
    }

    public boolean update(UUID id, String firstName, String lastName, int age) {
        try (
                Connection connection = DriverManager.getConnection(dbURL);
                PreparedStatement statement = conn.prepareStatement(UPDATE)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean delete(UUID id) {
        try(Connection connection = DriverManager.getConnection(dbURL);
            PreparedStatement statement = conn.prepareStatement(UPDATE)) {
            statement.setObject(1, id);
            statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
