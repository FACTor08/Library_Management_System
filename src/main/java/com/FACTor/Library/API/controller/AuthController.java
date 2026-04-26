package com.FACTor.Library.API.controller;

import com.FACTor.Library.API.component.JwtUtil;
import com.FACTor.Library.API.dto.LoginRequest;
import com.FACTor.Library.API.entity.User;
import com.FACTor.Library.API.service.LoginLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
@Autowired
private JwtUtil jwtUtil;
@Autowired
private LoginLogic logic;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){

        User user = logic.login(request);
        System.out.println("token: " + jwtUtil.generateToken(user));
        return jwtUtil.generateToken(user);
        }

    }

