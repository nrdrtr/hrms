package com.example.hrms.bussiness.abstracts;

import com.example.hrms.core.utilies.results.DataResult;
import com.example.hrms.core.utilies.results.Result;
import com.example.hrms.entities.concretes.JobSeeker;


import java.util.List;

public interface JobSeekerService {

    DataResult<List<JobSeeker>> getAll();
    Result save (JobSeeker jobSeeker);

}
