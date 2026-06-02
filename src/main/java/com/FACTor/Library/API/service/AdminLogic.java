package com.FACTor.Library.API.service;

import com.FACTor.Library.API.dto.AdminDTO;
import com.FACTor.Library.API.entity.User;
import com.FACTor.Library.API.mapper.AdminMapper;
import com.FACTor.Library.API.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminLogic {

    @Autowired
    private UserRepo repo;
    @Autowired
    private AdminMapper transfer;

    public String addMember(AdminDTO admin) {
        if (repo.findByEmailIgnoreCase(admin.getEmail()).isPresent()) {
            return "Email already exists";
        }
        User member = transfer.dataTransf(admin);
        repo.save(member);
        return "Admin successfully registered with lib id: " + member.getLibraryId() ;
    }
}
