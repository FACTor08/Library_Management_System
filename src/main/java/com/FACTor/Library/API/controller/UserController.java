package com.FACTor.Library.API.controller;

import com.FACTor.Library.API.dto.AdminDTO;
import com.FACTor.Library.API.dto.UserDTO;
import com.FACTor.Library.API.service.AdminLogic;
import com.FACTor.Library.API.service.UserLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserLogic user;
    @Autowired
    private AdminLogic admin;

    @PostMapping("/user-signup")
    public ResponseEntity<String> newUser(@RequestBody UserDTO data){
        String successMsg = user.addMember(data);
        return ResponseEntity.ok(successMsg);
    }

    @PostMapping("/administrator/admin-signup")
    public ResponseEntity<String> newAdmin(@RequestBody AdminDTO data){
        String successMsg = admin.addMember(data);
        return ResponseEntity.ok(successMsg);
    }

}
