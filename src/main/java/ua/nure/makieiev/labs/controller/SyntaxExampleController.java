package ua.nure.makieiev.labs.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SyntaxExampleController {

    static final String INDEX_PAGE = "syntaxExample";
    static final String SYNTAX_EXAMPLE_LINK = "/syntax/example";

    @GetMapping(value = "/syntax/example")
    public String getSyntaxExamplePage(Model model) {
        model.addAttribute("companiesUrl", "/api/companies");
        model.addAttribute("defaultName", "Peter Parker");
        model.addAttribute("greetings", "Hello World");
        return INDEX_PAGE;
    }


}
