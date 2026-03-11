package com.factor.school.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AdminDTO {
    private String firstname;
    private String otherNames;
    private String lastname;
    private String email;
    private String phone;
    private String password;
    private String imagetype;
}
