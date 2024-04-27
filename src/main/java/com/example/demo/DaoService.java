package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DaoService {

    public void beforeWithArgument(Argument argument) {
        log.info("Before -- {} - {}", argument.text(), argument.number());
    }

    public void afterWithArgument(Argument argument) {
        log.info("After -- {} - {}", argument.text(), argument.number());
    }
}
