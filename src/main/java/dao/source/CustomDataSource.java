package dao.source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomDataSource {

    private  String jdbcUrl;
    private  String username;
    private  String password;

    public CustomDataSource() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        this.jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        this.username = "postgres";
        this.password = "postgres";
    }
    public CustomDataSource(String url , String username , String password)  throws ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        this.jdbcUrl = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl , username, password);
    }

}
