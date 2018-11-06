package pl.coderslab.day1homework.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class DBCustomerLogger implements CustomerLogger {
    private DBBean dbBean;
    private static String ADD_LOGGER = "INSERT INTO loggers(data) VALUES (?)";

    @Autowired
    public void setDbBean(DBBean dbBean){
        this.dbBean = dbBean;
    }

    @Override
    public void log() {
        Connection connection = dbBean.getConnection();
        if(connection != null){
            String data = LocalDateTime.now() + ": Customer operation";
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(ADD_LOGGER);
                preparedStatement.setString(1, data);
                preparedStatement.executeUpdate();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
