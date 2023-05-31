package com.basic.myspringboot.runner;

import com.basic.myspringboot.property.MyBootProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Value("${myboot.name}")
    private String name;
    @Value("${myboot.age}")
    private int age;

    @Autowired
    MyBootProperties myBootProperties;

    @Autowired
    String hello;

    private Logger logger = LoggerFactory.getLogger(MyApplicationRunner.class);

    public void run(ApplicationArguments args) throws Exception {
        logger.debug("Logger 구현체 클래스명 = {}", logger.getClass().getName());
        logger.debug("현재 Environment = {}", hello);
        logger.debug("환경변수 Name = {}", name);
        logger.debug("환경변수 Age = {}", age);

        logger.info("MyBootProperties Age = {}", myBootProperties.getAge());
        logger.info("MyBootProperties FullName = {}", myBootProperties.getFullName());
        logger.info("VM Argument foo : {}", args.containsOption("foo"));
        logger.info("Application Argument bar : {}", args.containsOption("bar"));
    }

}