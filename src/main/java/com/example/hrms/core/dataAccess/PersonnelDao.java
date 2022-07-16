package com.example.hrms.core.dataAccess;

import com.example.hrms.core.entities.personnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelDao extends JpaRepository<personnel,Integer> {
    personnel findByEmail(String email);
}
