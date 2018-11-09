package pl.coderslab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class MaxController {
    @RequestMapping("/random/{min}/{max}")
    @ResponseBody
    public String max(@PathVariable("max") int max, @PathVariable("min") int min){
        Random random = new Random();
        int number = random.nextInt(max-min + 1) + min;
        return "Użytkownik podał wartości " + min + " i " + max + ". Wylosowano liczbę: " + number;
    }
}
