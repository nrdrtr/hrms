package com.example.hrms.bussiness.concretes;

import com.example.hrms.bussiness.abstracts.EmployerService;
import com.example.hrms.core.utilies.results.DataResult;
import com.example.hrms.core.utilies.results.Result;
import com.example.hrms.core.utilies.results.SuccessDataResult;
import com.example.hrms.core.utilies.results.SuccessResult;
import com.example.hrms.dataAccess.EmployerDao;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private final EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        super();
        this.employerDao = employerDao;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
      return   new SuccessDataResult<List<Employer>>
              (employerDao.findAll(),"Data listed successfully");
    }

    @Override
    public Result save(Employer employer) {
        employerDao.save(employer);
        return new SuccessResult("Employer saved");
    }
}

