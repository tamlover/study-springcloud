package com.study.configclient;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigClientApplicationTests {

    @Test
    public void contextLoads() {
        String aa = null;
        org.springframework.util.Assert.notNull(aa,"aa can't null");
        System.out.println("aa");
    }

}
