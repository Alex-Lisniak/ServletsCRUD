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
            //System.out.println(dao.findAll(dao.getDataSource().getConnection()).toString());

//            CustomDataSource customDataSource = new CustomDataSource();
//            Connection connection = customDataSource.getConnection();
//            Statement statement = connection.createStatement();
//            //statement.executeUpdate("INSERT INTO users (user_name, user_surname, user_age) values (542 ,1,2)");
//
//            ResultSet set = statement.executeQuery("SELECT * FROM users");
//            while(set.next()){
//                System.out.println(set.getString("user_name"));
//            }

        } catch(StudentNotFoundException userNotFoundException ){
            System.out.println(userNotFoundException.getMessage());

        } catch(SQLException sqlException ){
            System.out.println("Found sql exception on statements : " + sqlException.getMessage());
        }
    }
}
