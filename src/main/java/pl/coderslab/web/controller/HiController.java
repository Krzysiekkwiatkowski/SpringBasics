package pl.coderslab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HiController {
    @RequestMapping("/hi")
    @ResponseBody
    public String hi(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return "Witaj " + firstName + " " + lastName;
    }
}
