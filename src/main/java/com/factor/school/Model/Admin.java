package com.factor.school.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String otherNames;
    private String lastname;
    private String staffId;

    @Email(message = "Input a valid email address")
    private String email;

    private String password;

    @Size(min = 11, max = 11, message = "Input a valid phone number")
    private String phone;

    private Role role;

    @Lob
    private byte[] image;

    private String imagetype;

}
