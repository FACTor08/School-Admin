package com.factor.school.Component;

import com.factor.school.Model.Admin;
import com.factor.school.Model.AdminDTO;
import com.factor.school.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
public class AdminDataTransfer {
    @Autowired
  private PasswordEncoder encoder;

    private static final Random random = new Random();

    public String StaffIdGenerator(){return "STF" + LocalDate.now().getYear() + (100 + random.nextInt(900));}

    public Admin transfer(AdminDTO data, byte[] photo, String photoType){

    Admin administrator = new Admin();
            administrator.setFirstname(data.getFirstname());
            administrator.setLastname(data.getLastname());
            administrator.setOtherNames(data.getOtherNames());
            administrator.setEmail(data.getEmail());
            administrator.setPhone(data.getPhone());
            administrator.setPassword(encoder.encode(data.getPassword()));
            administrator.setStaffId(StaffIdGenerator());
            administrator.setImage(photo);
            administrator.setRole(Role.ROLE_ADMIN);
            administrator.setImagetype(photoType);

    return administrator;
    }
}
