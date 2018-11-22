package com.study.eurekacustomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
public class EurekaCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaCustomerApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return "hello:"+name+" i am customer";
//        return restTemplate.getForObject("http://CLIENT/hi?name="+name,String.class);
    }

    @GetMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne(name);
    }

}
