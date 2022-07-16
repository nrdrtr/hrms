package com.example.hrms.bussiness.concretes;

import com.example.hrms.bussiness.abstracts.JobPositionService;
import com.example.hrms.core.utilies.results.*;
import com.example.hrms.dataAccess.JobPositionDao;
import com.example.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager  implements JobPositionService {


    private final JobPositionDao positionDao;

    @Autowired
    public JobPositionManager(JobPositionDao positionDao) {
        super();
        this.positionDao = positionDao;
    }

    @Override
    public DataResult<List<JobPosition>>  getAll() {
        return new SuccessDataResult<List<JobPosition>>
                (positionDao.findAll(),"Data listed successfully");
    }



    public Result isJobPositionExist(String title) {
        if(!(this.positionDao.findByPositionTitle(title) == null)) {
            return new ErrorResult();
        }
        return new SuccessResult();
    }

    @Override
    public Result add(JobPosition jobPosition) {

        if(!this.isJobPositionExist(jobPosition.getPositionTitle()).isSuccess()) {
            return new ErrorResult("job position available in the system. Please add a job position that is not available in the system.");
        }
        this.positionDao.save(jobPosition);
        return new SuccessResult("Job position added to the system");

    }

}
