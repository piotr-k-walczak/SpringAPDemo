package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final AnnotatedService annotatedService;

    public Controller(AnnotatedService annotatedService) {
        this.annotatedService = annotatedService;
    }

    @GetMapping("/correct")
    public void callGet() {
        annotatedService.doSomethingWithArgs(new Argument(1, "TXT"));
    }

    @GetMapping("/exception")
    public void callGetExc() {
        annotatedService.doSomething();
    }
}
