package com.study.eurekacustomer;

import org.springframework.stereotype.Component;

/**
 * @author qili.hu
 * @date 2018/11/26 13:58
 */
@Component
public class SchedulalImpl implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return name+" fallback!!";
    }
}
