package com.bistu.springboot01helloworldquick.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping(value = "/user/logout")
    public String Logout(HttpSession session){
        session.removeAttribute("loginUser");
        return "login";
    }
}
