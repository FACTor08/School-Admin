package com.factor.school.Service;

import com.factor.school.Component.AdminDataTransfer;
import com.factor.school.Model.Admin;
import com.factor.school.Model.AdminDTO;
import com.factor.school.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;

@Service
@Transactional
public class AdminLogic {
@Autowired
    private AdminRepo repo;
@Autowired
    private AdminDataTransfer dto;

        public String addStaff(AdminDTO data, MultipartFile image) throws IOException {
            byte[] photo = image.getBytes();
            String photoType = image.getContentType();
            Admin staff = dto.transfer(data, photo, photoType);

            repo.save(staff);
        return "new Admin (" + data.getLastname() +" "+ data.getFirstname() + ") registered successfully";
        }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin administrator = repo.findByStaffId(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                administrator.getStaffId(),
                administrator.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(administrator.getRole().name()))
        );
    }
}
