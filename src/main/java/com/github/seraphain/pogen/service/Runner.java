package com.github.seraphain.pogen.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Runner implements InitializingBean {

    @Autowired
    private PogenService pogenService;

    @Override
    public void afterPropertiesSet() throws Exception {
        pogenService.generate();
    }

}
