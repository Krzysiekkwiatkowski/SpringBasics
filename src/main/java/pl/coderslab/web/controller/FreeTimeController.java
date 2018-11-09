package pl.coderslab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
public class FreeTimeController {
    @RequestMapping("/time")
    @ResponseBody
    public String time() {
        LocalDateTime date = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        String day = date.getDayOfWeek().toString();
        int time = date.getHour();
        if(day.equals("SATURDAY") || day.equals("SUNDAY")){
            return "Wolne";
        } else {
            if(time >= 9 && time <= 17){
                return "Pracuje, nie dzwoń.";
            } else {
                return "Po Pracy";
            }
        }
    }
}
