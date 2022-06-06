import dao.implementation.DaoImpl;
import dao.source.CustomDataSource;
import exceptions.StudentNotFoundException;
import model.Student;

import java.sql.Connection;

import java.sql.SQLException;


public class JDBCTesting {
    public static void main(String[] args) throws ClassNotFoundException {
        DaoImpl dao = new DaoImpl(new CustomDataSource());
        try {
            Connection connection = dao.getDataSource().getConnection();
            System.out.println(dao.findById(connection, 1L));
            System.out.println(dao.findAll(connection).toString());
            dao.save(connection , new Student(543L , "name" , "surname" , 15));
            System.out.println(dao.findAll(connection).toString());
            dao.deleteById(connection ,5L );

            System.out.println(dao.findAll(connection).toString());


        } catch(StudentNotFoundException userNotFoundException ){
            System.out.println(userNotFoundException.getMessage());

        } catch(SQLException sqlException ){
            System.out.println("Found sql exception on statements : " + sqlException.getMessage());
        }
    }
}
