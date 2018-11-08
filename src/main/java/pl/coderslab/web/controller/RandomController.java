package pl.coderslab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {
    @RequestMapping("/showRandom")
    @ResponseBody
    public String showRandom(){
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        return "Wylosowano liczbę: " + number;
    }
}
