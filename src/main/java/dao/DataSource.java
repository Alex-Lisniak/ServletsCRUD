package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private  String jdbcUrl;
    private  String username;
    private  String password;

    public DataSource (){
        this.jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        this.username = "postgres";
        this.password = "postgres";
    }
    DataSource (String url , String username , String password){
        this.jdbcUrl = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl , username, password);
    }

}
