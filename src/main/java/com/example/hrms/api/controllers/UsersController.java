package com.example.hrms.api.controllers;

import com.example.hrms.bussiness.abstracts.PersonnelService;
import com.example.hrms.core.entities.personnel;
import com.example.hrms.core.utilies.results.ErrorDataResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private PersonnelService personnelService;

    public UsersController(PersonnelService personnelService) {
        super();
        this.personnelService = personnelService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody personnel personnel) {
        return ResponseEntity.ok(this.personnelService.add(personnel));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)//500hatası

    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {

            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
        return errors;
    }





}
