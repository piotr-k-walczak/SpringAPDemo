package com.example.demo.aop;

import com.example.demo.Argument;
import com.example.demo.DaoService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Aspect
@Component
public class EnableForExecutionAspect {

    private final DaoService daoService;

    public EnableForExecutionAspect(DaoService daoService) {
        this.daoService = daoService;
    }

    @Pointcut("@annotation(com.example.demo.aop.EnableForExecution)")
    public void enableMethods() {}

    @Around("enableMethods()")
    public Object enableForExecution(ProceedingJoinPoint pjp) throws Throwable {
        Optional<Argument> a = Arrays.stream(pjp.getArgs())
                .filter(Argument.class::isInstance)
                .map(Argument.class::cast)
                .findFirst();
        if (a.isPresent()) {
            daoService.beforeWithArgument(a.get());
            Object ret = pjp.proceed();
            daoService.afterWithArgument(a.get());
            return ret;
        } else {
            throw new MissingArgumentException();
        }
    }
}
