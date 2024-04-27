package com.example.demo;

import com.example.demo.aop.EnableForExecution;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AnnotatedService {

    @EnableForExecution
    public void doSomethingWithArgs(Argument argument) {
        log.info("Do something with Args");
    }

    @EnableForExecution
    public void doSomething() {
        log.info("Do something");
    }
}
