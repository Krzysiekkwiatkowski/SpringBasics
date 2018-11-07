package pl.coderslab.day1homework.beans;

import org.springframework.stereotype.Component;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@Component
public class FileCustomerLogger implements CustomerLogger {
    private String filename = "CustomerLogger.txt";

    @Override
    public void log() {
        try {
            PrintWriter printWriter = new PrintWriter(filename);
            printWriter.println(LocalDateTime.now() + ": Customer operation");
            printWriter.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
