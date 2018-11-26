package com.study.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@EnableHystrix
@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaClientApplication {


    @Autowired
    private ClientService clientService;

    @Value("${server.port}")
    String port;

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @GetMapping(value = "hi")
    @ResponseBody
    public String hi(@RequestParam String name) {

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello," + name +" "+", i am "+port;
    }


    @GetMapping(value = "hello")
    @ResponseBody
    public String hello(@RequestParam String name) {
        return clientService.testHystrix(name);
    }

}
