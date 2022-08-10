package br.com.bb.exemplo.springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping({"/"})
    public String home(){
        return "Tela de home.. hello springboot world";
    }
}
