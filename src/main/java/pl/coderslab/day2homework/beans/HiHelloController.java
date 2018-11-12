package pl.coderslab.day2homework.beans;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

@Controller
public class HiHelloController {
    @RequestMapping("/workers")
    public String workersAction(Model model) {
        Path path = Paths.get("/home/oem/Coderslab/SpringBasics/Workers.txt");
        Random random = new Random();
        int number = random.nextInt(30) + 1;
        String worker = "";
        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine(), ",");
                int obtainedNumber = Integer.parseInt(stringTokenizer.nextToken());
                if(obtainedNumber == number){
                    worker = stringTokenizer.nextToken();
                }
            }
            model.addAttribute("worker", worker);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "workers";
    }
}
