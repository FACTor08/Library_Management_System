package com.FACTor.Library.API.controller;

import com.FACTor.Library.API.config.JwtUtil;
import com.FACTor.Library.API.dto.LoginRequest;
import com.FACTor.Library.API.entity.User;
import com.FACTor.Library.API.service.LoginLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
private final JwtUtil jwtUtil;
private final LoginLogic logic;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){

        User user = logic.login(request);
        System.out.println("token: " + jwtUtil.generateToken(user));
        return jwtUtil.generateToken(user);
        }

    }

