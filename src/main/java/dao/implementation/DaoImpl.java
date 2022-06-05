package dao.implementation;


import dao.source.CustomDataSource;
import exceptions.StudentNotFoundException;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoImpl {

    public static final String INSERT_ONE = "INSERT INTO students (student_name, student_surname, student_age) values (?,?,?)";
    public static final String SELECT_ONE = "SELECT * FROM students where student_id = ?";
    public static final String SELECT_ALL = "SELECT * FROM students";
    public static final String UPDATE_ONE = "UPDATE students SET student_name = ?, student_surname = ?, student_age = ? where student_id = ?";
    public static final String DELETE_ONE = "DELETE FROM students WHERE student_id = ?";

    private CustomDataSource customDataSource;

    public DaoImpl(CustomDataSource customDataSource){
        this.customDataSource = customDataSource;
    }

    public boolean save(Connection connection , Student student)throws SQLException {
        try(PreparedStatement pStatement = connection.prepareStatement(INSERT_ONE)){
            pStatement.setString(1, student.getName());
            pStatement.setString(2, student.getSurname());
            pStatement.setInt(3,student.getAge());
            if(pStatement.execute()) return true;
        }
        return false;
    }
    public boolean deleteById(Connection connection , Long id)throws SQLException{
        try(PreparedStatement pStatement = connection.prepareStatement(DELETE_ONE)){
            pStatement.setLong(1,  id);
            if(pStatement.execute()) return true;
        }
        return false;
    }
    public boolean update(Connection connection , Student student)throws SQLException{
        try(PreparedStatement pStatement = connection.prepareStatement(UPDATE_ONE)){
            pStatement.setString(1, student.getName());
            pStatement.setString(2, student.getSurname());
            pStatement.setInt(3,student.getAge());
            if(pStatement.execute()) return true;
        }
        return false;
    }
    public Student findById(Connection connection , Long id)throws SQLException , StudentNotFoundException {
        try(PreparedStatement pStatement = connection.prepareStatement(SELECT_ONE)){
            pStatement.setLong(1,  id);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()){
                if(resultSet.getLong("student_id") == id){
                    return new Student(id, resultSet.getString("student_name"),
                                        resultSet.getString("student_surname"),
                                        resultSet.getInt("student_age"));
                }
            }
            throw new StudentNotFoundException();
        }
    }

    public List<Student> findAll(Connection connection)throws SQLException  , StudentNotFoundException {
        try(PreparedStatement pStatement = connection.prepareStatement(SELECT_ALL)){
            List<Student> studentList = new LinkedList<>();
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()){
                    studentList.add(new Student(resultSet.getLong("student_id"),
                            resultSet.getString("student_name"),
                            resultSet.getString("student_surname"),
                            resultSet.getInt("student_age")));
                }

            if(studentList.size() > 0) return studentList;
        }
        throw new StudentNotFoundException();

    }

    public CustomDataSource getDataSource(){ return customDataSource; }
}
