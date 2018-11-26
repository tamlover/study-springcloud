package com.study.eurekaclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author qili.hu
 * @date 2018/11/26 10:53
 */
@Service
public class ClientService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallback")
    public String testHystrix(String name){

        ResponseEntity responseEntity = restTemplate.getForEntity("http://CUSTOMER/hi?name={name}", String.class, name);
        return (String) responseEntity.getBody();
    }

    public String fallback(String name) {
        return name+" fallback";
    }
}
