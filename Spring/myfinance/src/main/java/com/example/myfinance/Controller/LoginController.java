package com.example.myfinance.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {
    @GetMapping("/req/login")
    String login() {
        return "login";
    }
    @GetMapping("/req/signup")
    public String signup(){
        return "signup";
    }
    @GetMapping("/homepage")
    public String home(){
        return "homepage";
    }
    @GetMapping("/report")
    public String report(){
        return "report";
    }

    @GetMapping("/news")
    public String news(){
        return "news";
    }



}