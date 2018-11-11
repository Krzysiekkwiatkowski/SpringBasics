package pl.coderslab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
public class SessionController {
    @RequestMapping("/session")
    @ResponseBody
    public String session(HttpSession session){
        Object valueObject = session.getAttribute("loginStart");
        if(valueObject == null){
            return "" + LocalDateTime.now();
        } else {
            return (String) valueObject;
        }
    }
}
