package com.example.hrms.dataAccess;

import com.example.hrms.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
    JobPosition findByPositionTitle(String positionTitle);
}
