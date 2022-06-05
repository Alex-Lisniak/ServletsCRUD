import dao.DataSource;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class JDBCTesting {
    public static void main(String[] args) {
        try {


            DataSource dataSource = new DataSource();
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            //statement.executeUpdate("INSERT INTO users (user_name, user_surname, user_age) values (542 ,1,2)");

            ResultSet set = statement.executeQuery("SELECT * FROM users");
            while(set.next()){
                System.out.println(set.getString("user_name"));
            }

        } catch(SQLException sqlException){
            System.out.println("Found sql exception on statements : " + sqlException.getMessage());
        }
    }
}
