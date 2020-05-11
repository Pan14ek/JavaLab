package ua.nure.makieiev.labs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {

    @GetMapping("/greeting")
    public String getInformation(Model model) {
        String text = "Oleksii Makieiev PZPI-17-1, My First Spring Application";
        model.addAttribute("greeting", text);
        return "greeting";
    }

}
