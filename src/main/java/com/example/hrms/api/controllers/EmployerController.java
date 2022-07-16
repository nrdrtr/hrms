package com.example.hrms.api.controllers;

import com.example.hrms.bussiness.abstracts.EmployerService;
import com.example.hrms.core.utilies.results.DataResult;
import com.example.hrms.core.utilies.results.Result;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {

    private final EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        super();
        this.employerService = employerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @PostMapping("/save")
    public Result save(@RequestBody Employer employer){
        return this.employerService.save(employer);
    }


}
