package com.bistu.springboot01helloworldquick.controller;

import com.bistu.springboot01helloworldquick.dao.ItemRepository;
import com.bistu.springboot01helloworldquick.dao.UserRepository;
import com.bistu.springboot01helloworldquick.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {


    @Autowired
    UserRepository userRepository;


    @GetMapping(value = "/user/register")
    public String Register(){
        return "register";
    }

    @PostMapping("/addUser")
    public String addUser(User user,
                          @RequestParam("user_account") String user_account,
                          @RequestParam("user_password") String user_password){
        System.out.println("用户account:"+user_account);
        System.out.println("用户password:"+user_password);
        user.setUser_account(user_account);
        user.setUser_password(user_password);
        user.setUser_limits(0);
        userRepository.save(user);
        return "login";
    }
}
