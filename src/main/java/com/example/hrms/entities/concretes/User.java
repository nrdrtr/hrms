package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
//    @ApiModelProperty(hidden = true) //readonly
    private int id;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "password")
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull
    @Column(name = "passwordAgain")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordAgain;


}
