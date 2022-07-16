package com.example.hrms.bussiness.concretes;

import com.example.hrms.bussiness.abstracts.JobSeekerService;
import com.example.hrms.core.utilies.results.*;
import com.example.hrms.dataAccess.JobSeekerDao;
import com.example.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //logic error
public class JobSeekerManager implements JobSeekerService {

    private final JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        super();
        this.jobSeekerDao = jobSeekerDao;
    }


    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>
                (jobSeekerDao.findAll(), "Data listed successfully");
    }


    public Result isEmailExist(String email) {
        if(this.jobSeekerDao.findByEmail(email) == null) {
            return new SuccessResult();
        }
        return new ErrorResult();
    }
    public Result isIdentificationNumberExist(String identificationNumber) {
        if(this.jobSeekerDao.findByIdentityNumber(identificationNumber) == null) {
            return new SuccessResult();
        }
        return new ErrorResult();
    }


    @Override
    public Result save(JobSeeker jobSeeker) {
        if (jobSeeker.getFirstName() == null && jobSeeker.getLastName() == null && jobSeeker.getIdentityNumber() == null
                && jobSeeker.getBirthDate() == null && jobSeeker.getPassword() == null && jobSeeker.getEmail()== null
                && jobSeeker.getPasswordAgain() == null) {

            return new ErrorResult("lütfen boş alanları doldurunuz");

            } else if(!this.isIdentificationNumberExist(jobSeeker.getIdentityNumber()).isSuccess()) {
                return new ErrorResult("t.c. available in the system. Please add a T.C. that is not available in the system.");
            }else if (!this.isEmailExist(jobSeeker.getEmail()).isSuccess()){
                return new ErrorResult("email available in the system. Please add a email that is not available in the system.");

            }else{
                this.jobSeekerDao.save(jobSeeker);
                return new SuccessResult("iş arayan eklendi");
            }
        }


    }



















