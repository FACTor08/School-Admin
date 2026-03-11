package com.factor.school.Controller;

import com.factor.school.Model.AdminDTO;
import com.factor.school.Service.AdminLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/Admin-Portal")
public class AdminController {
    @Autowired
    private AdminLogic logic;

    @PostMapping(value = "/Admin-Registration")
    public ResponseEntity<String> addAdmin(@ModelAttribute AdminDTO data,@RequestPart MultipartFile staffImage)
            throws IOException {
        String msg = logic.addStaff(data, staffImage);

        return ResponseEntity.ok(msg);
    }
}
