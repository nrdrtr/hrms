package com.example.hrms.bussiness.abstracts;

import com.example.hrms.core.utilies.results.DataResult;
import com.example.hrms.core.utilies.results.Result;
import com.example.hrms.entities.concretes.Employer;

import java.util.List;


public interface EmployerService {

    DataResult<List<Employer>> getAll();
    Result save(Employer employer);

}
