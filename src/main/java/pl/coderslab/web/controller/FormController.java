package pl.coderslab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/first")
public class FormController {
    @GetMapping("/form")
    public String get(){
        return "form.jsp";
    }

    @PostMapping("/form")
    @ResponseBody
    public String post(@RequestParam("paramName") String paramName){
        return "Twój parametr to: " + paramName;
    }
}
