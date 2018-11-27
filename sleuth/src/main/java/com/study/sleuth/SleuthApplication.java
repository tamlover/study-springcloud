package com.study.sleuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@RestController
@SpringBootApplication
public class SleuthApplication {

    private static final Logger log = LoggerFactory.getLogger(SleuthApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SleuthApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @ResponseBody
    @GetMapping(value = "client")
    public ResponseEntity getClient(@RequestParam  String name) {
        log.info("___________client____________");
        ResponseEntity<String> message = getRestTemplate().getForEntity("http://client/hi?name={name}", String.class, name);
        return new ResponseEntity(message.getBody(), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "customer")
    public ResponseEntity getCustomer(@RequestParam  String name) {
        log.info("___________customer____________");
        ResponseEntity<String> message = getRestTemplate().getForEntity("http://customer/hi?name={name}", String.class, name);
        return new ResponseEntity(message.getBody(), HttpStatus.OK);
//        return "Trace";
    }
}
