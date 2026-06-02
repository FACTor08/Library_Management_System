package com.FACTor.Library.API.service;

import com.FACTor.Library.API.dto.UserDTO;
import com.FACTor.Library.API.mapper.UserMapper;
import com.FACTor.Library.API.entity.User;
import com.FACTor.Library.API.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserLogic {
    @Autowired
    private UserRepo repo;
    @Autowired
    private UserMapper transfer;

    public String addMember(UserDTO user){
        if (repo.findByEmailIgnoreCase(user.getEmail()).isPresent()){
           return "Email already exists";
        }
        User member = transfer.dataTransf(user);
        repo.save(member);
        return "User successfully registered with lib id: " + member.getLibraryId();
    }


}
