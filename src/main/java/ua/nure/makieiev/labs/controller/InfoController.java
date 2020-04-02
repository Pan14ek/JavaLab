package ua.nure.makieiev.labs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/")
    public String getInformation() {
        return "Oleksii Makieiev PZPI-17-1, My First Spring Application";
    }

}
