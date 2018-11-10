package pl.coderslab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MultiplyController {
    @RequestMapping("/multiply")
    public String multiply(@RequestParam(required = false) Integer size, Model model){
        if(size == null){
            size = 10;
            model.addAttribute("size", size);
        } else {
            model.addAttribute("size", size);
        }
        return "multiply";
    }

    @RequestMapping("/paramMultiply/{rows}/{cols}")
    public String paramMultiply(@PathVariable("rows") int rows, @PathVariable("cols") int cols, Model model){
        model.addAttribute("rows", rows);
        model.addAttribute("cols", cols);
        return "paramMultiply";
    }
}
