package com.example.hrms.dataAccess;

import com.example.hrms.entities.concretes.JobSeeker;
import com.example.hrms.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
   User findByEmail(String email);
   JobSeeker findByIdentityNumber(String identityNumber);

}
