package com.example.hrms.bussiness.abstracts;

import com.example.hrms.core.entities.personnel;
import com.example.hrms.core.utilies.results.DataResult;
import com.example.hrms.core.utilies.results.Result;

public interface PersonnelService {
    Result add(personnel user);
    DataResult<personnel> findByEmail(String email);
}
