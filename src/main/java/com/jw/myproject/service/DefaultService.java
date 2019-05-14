package com.jw.myproject.service;

import org.springframework.stereotype.Service;

@Service
public interface DefaultService {
    default String getD(){
        return "123";
    }
}
