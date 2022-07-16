package com.example.hrms.bussiness.abstracts;

import com.example.hrms.core.utilies.results.DataResult;
import com.example.hrms.core.utilies.results.Result;
import com.example.hrms.entities.concretes.JobPosition;
import java.util.List;


public interface JobPositionService {
    DataResult <List<JobPosition>>  getAll();
    Result add(JobPosition jobPosition);
}
