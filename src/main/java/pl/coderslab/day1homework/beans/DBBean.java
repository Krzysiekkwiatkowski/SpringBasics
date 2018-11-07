package pl.coderslab.day1homework.beans;

import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DBBean {
    private static Connection connection;

    Connection getConnection(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nauka?useSSL=false&characterEncoding=utf8", "root", "coderslab");
            return connection;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
