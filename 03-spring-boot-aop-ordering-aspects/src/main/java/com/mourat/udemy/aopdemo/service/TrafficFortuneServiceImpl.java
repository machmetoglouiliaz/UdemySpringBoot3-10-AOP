package com.mourat.udemy.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{


    @Override
    public String getFortune() throws Exception{
        return getFortune(false);
    }

    @Override
    public String getFortune(boolean excFlag) throws Exception {
        if(excFlag) throw new RuntimeException("Ooops! Something wrong! Just kidding... It's just a dummy test exception :P");

        TimeUnit.SECONDS.sleep(5);

        return "It's your lucky day!";
    }
}
