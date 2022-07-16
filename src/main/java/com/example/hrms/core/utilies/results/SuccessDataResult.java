package com.example.hrms.core.utilies.results;

import java.util.List;

public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T data) {
        super(data,true);
    }

    public SuccessDataResult(T data,  String message) {
        super(data, true, message);
    }
    public SuccessDataResult(String  message) {
        super(null, true, message);
    }

    public SuccessDataResult(List<Integer> all, String data_listed_successfully) {
        super(null, true);
    }
}
