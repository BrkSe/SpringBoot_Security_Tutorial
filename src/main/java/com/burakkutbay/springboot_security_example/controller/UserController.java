package com.burakkutbay.springboot_security_example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/dashboard")
    public String  dashboard() {
        return "Üyelere özel mesajdır";
    }

    @GetMapping("/index")
    public String index(){
        return "Merhaba. Üye Olun";
    }
}
