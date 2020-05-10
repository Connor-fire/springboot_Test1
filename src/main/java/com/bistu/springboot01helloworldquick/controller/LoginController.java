package com.bistu.springboot01helloworldquick.controller;

import com.bistu.springboot01helloworldquick.dao.UserRepository;
import com.bistu.springboot01helloworldquick.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;



    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object>map,
                        HttpSession session)
    {

        List<User> all_user = userRepository.findAll();
        String s="";
        for(int i = 0;i<all_user.size();i++){
            if(all_user.get(i).getUser_account().equals(username) && all_user.get(i).getUser_password().equals(password)){
                session.setAttribute("loginUser",username);
                session.setAttribute("limits",all_user.get(i).getUser_limits());
                session.setAttribute("userId",all_user.get(i).getUser_id());
                s="redirect:/main.html";
                break;
            }if(i==all_user.size()-1){
                map.put("msg","用户密码错误");
                s="login";
                break;
            }
        }
        return s;
    }
}
