package com.example.hrms.api.controllers;

import com.example.hrms.bussiness.abstracts.JobSeekerService;
import com.example.hrms.core.utilies.results.DataResult;
import com.example.hrms.core.utilies.results.Result;
import com.example.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/jobseeker")
@RestController
public class JobSeekerController {

    private final JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        super();
        this.jobSeekerService = jobSeekerService;
    }


    @GetMapping("/getAll")
    public DataResult<List<JobSeeker>>getAll(){
        return  this.jobSeekerService.getAll();

    }
    @PostMapping("/save")
    public Result save(@RequestBody JobSeeker jobSeeker){
        return  this.jobSeekerService.save(jobSeeker);

    }



}
