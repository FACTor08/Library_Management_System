package com.FACTor.Library.API.service;

import com.FACTor.Library.API.entity.User;
import com.FACTor.Library.API.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomUserDetails implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

            User user = repo.findByLibraryId(id)
                    .orElseThrow(()-> new RuntimeException("User Not Found"));
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getLibraryId())
                    .password(user.getPassword())
                    .authorities(user.getRole().name())
                    .build();
        }


    }

