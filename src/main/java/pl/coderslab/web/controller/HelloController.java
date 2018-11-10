package pl.coderslab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalTime;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld(){
        return "Hello World";
    }

    @RequestMapping("/helloView")
    public String helloView(Model model){
        LocalTime time = LocalTime.now();
        String color = "";
        String backgroundColor = "";
        if (time.getHour() >= 8 && time.getHour() < 20){
            color = "black";
            backgroundColor = "white";
            model.addAttribute("color", color);
            model.addAttribute("backgroundColor", backgroundColor);
        } else {
            color = "white";
            backgroundColor = "black";
            model.addAttribute("color", color);
            model.addAttribute("backgroundColor", backgroundColor);
        }
        return "home";
    }
}
