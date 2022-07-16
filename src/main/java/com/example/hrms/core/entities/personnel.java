package com.example.hrms.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_validation")
public class personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id ;


    @NotNull
    @NotBlank
    @Column(name = "email")
    private String email;

    @NotNull
    @NotBlank
    @Email
    @Column(name = "password")
    private String password;


}
