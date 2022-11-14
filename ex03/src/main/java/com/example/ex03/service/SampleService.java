package com.example.ex03.service;

import com.example.ex03.aspect.Plus10;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    @Plus10 /*pointcut*/
    public Integer doADD(String str1 , String str2) throws Exception{
         return Integer.parseInt(str1) + Integer.parseInt(str2);
    }
}
