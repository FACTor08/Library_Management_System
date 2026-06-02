package com.FACTor.Library.API.mapper;

import com.FACTor.Library.API.dto.UserDTO;
import com.FACTor.Library.API.entity.Role;
import com.FACTor.Library.API.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
public class UserMapper {
   @Autowired
    private PasswordEncoder encoder;


    private final Random random = new Random();
    public String libraryId(){
        return "lib" + (100 + random.nextInt(900) +""+ LocalDate.now().getYear());
    }

    public User dataTransf(UserDTO data){
        User user = new User();
        user.setFirstname(data.getFirstname());
        user.setEmail(data.getEmail());
        user.setLibraryId(libraryId());
        user.setPassword(encoder.encode(data.getPassword()));
        user.setPhone(data.getPhone());
        user.setRole(Role.ROLE_USER);
        user.setSurname(data.getSurname());

        return user;
    }
}
