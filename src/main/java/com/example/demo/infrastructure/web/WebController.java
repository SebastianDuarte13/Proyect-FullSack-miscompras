package com.example.demo.infrastructure.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    
    @GetMapping("/")
    public String index() {
        return "index";  // Asegúrate de que el archivo esté en 'src/main/resources/templates/index.html'
    }
}
