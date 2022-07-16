package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "website")
    private String website;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "picture_url")
    private String picture_url;

    @Column(name = "is_updated")
    private boolean is_updated;


}
