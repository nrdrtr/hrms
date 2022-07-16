package com.example.hrms.bussiness.concretes;

import com.example.hrms.bussiness.abstracts.PersonnelService;
import com.example.hrms.core.dataAccess.PersonnelDao;
import com.example.hrms.core.entities.personnel;
import com.example.hrms.core.utilies.results.DataResult;
import com.example.hrms.core.utilies.results.Result;
import com.example.hrms.core.utilies.results.SuccessDataResult;
import com.example.hrms.core.utilies.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements PersonnelService {

    private PersonnelDao userDao;

    @Autowired
    public UserManager(PersonnelDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public Result add(personnel user) {
        this.userDao.save(user);
        return new SuccessResult("user added");
    }

    @Override
    public DataResult<personnel> findByEmail(String email) {
        return new SuccessDataResult<personnel>(this.userDao.findByEmail(email),"user found");
    }
}
