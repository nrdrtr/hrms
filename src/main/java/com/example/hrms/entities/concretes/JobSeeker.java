package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobseekers", uniqueConstraints = {@UniqueConstraint(columnNames = {"identity_number"})})
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobSeeker extends User {

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "identity_number")
    @NotNull
    private String identityNumber;

    @Column(name = "birth_date")
    @NotNull
    private LocalDateTime birthDate;

    //@OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.DETACH)
    //private List<CurriculaVitae> curriculaVitaes;

    //@OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.DETACH)
   // private List<Favorite> favorites;
}