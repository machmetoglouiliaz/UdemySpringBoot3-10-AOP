package com.mourat.udemy.aopdemo.service;

public interface TrafficFortuneService {

    String getFortune() throws Exception;

    String getFortune(boolean excFlag) throws Exception;
}
