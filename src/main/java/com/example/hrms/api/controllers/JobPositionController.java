package com.example.hrms.api.controllers;

import com.example.hrms.bussiness.abstracts.JobPositionService;
import com.example.hrms.core.utilies.results.DataResult;
import com.example.hrms.core.utilies.results.Result;
import com.example.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/jobposition")
@RestController
public class JobPositionController {

    private final JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        super();
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public DataResult <List<JobPosition>> getAll(){
        return this.jobPositionService.getAll();

    }
    @PostMapping ("/save")
    public Result save(@RequestBody JobPosition jobPosition){
        return this.jobPositionService.add(jobPosition);
    }


}
