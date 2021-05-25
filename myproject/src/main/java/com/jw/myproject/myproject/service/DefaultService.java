package com.jw.myproject.myproject.service;

import org.springframework.stereotype.Service;

@Service
public interface DefaultService {
    default String getD(){
        return "123";
    }
}
