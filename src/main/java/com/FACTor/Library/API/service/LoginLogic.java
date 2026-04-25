package com.FACTor.Library.API.service;

import com.FACTor.Library.API.dto.LoginRequest;
import com.FACTor.Library.API.entity.User;
import com.FACTor.Library.API.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginLogic {
    private final PasswordEncoder encoder;

    public LoginLogic(PasswordEncoder encoder) {
        this.encoder = encoder;
    }
@Autowired
private UserRepo repo;

    public User login(LoginRequest request){

        User user = repo.findByLibraryId(request.getLibraryId())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        if (!encoder.matches(request.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid Credentials");
        }
        return user;
    }
}
