package com.FACTor.Library.API.mapper;

import com.FACTor.Library.API.dto.AdminDTO;
import com.FACTor.Library.API.entity.Role;
import com.FACTor.Library.API.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;
@Component
public class AdminMapper {

    private final PasswordEncoder encoder;

    public AdminMapper(PasswordEncoder encoder) {
        this.encoder = encoder;
    }
        private final Random random = new Random();

    public String libraryId(){
            return "lib" + (100 + random.nextInt(900) + "" + LocalDate.now().getYear());
        }

        public User dataTransf(AdminDTO data){
            User admin = new User();
            admin.setFirstname(data.getFirstname());
            admin.setEmail(data.getEmail());
            admin.setLibraryId(libraryId());
            admin.setPassword(encoder.encode(data.getPassword()));
            admin.setPhone(data.getPhone());
            admin.setRole(Role.ROLE_ADMIN);
            admin.setSurname(data.getSurname());

            return admin;
        }
    }