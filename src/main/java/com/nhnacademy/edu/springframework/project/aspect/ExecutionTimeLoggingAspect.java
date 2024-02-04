package com.nhnacademy.edu.springframework.project.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class ExecutionTimeLoggingAspect {

    @Pointcut("execution(* com.nhnacademy.edu.springframework.project.service..*.*(..))")
    public void serviceMethods() {}

    @Around("serviceMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try{
            return joinPoint.proceed();
        }catch (Throwable throwable){
            System.out.println(throwable.getMessage());
            throw throwable;
        }finally {
            stopWatch.stop();

            System.out.printf("[%s].[%s] [%d]ms%n",
                    joinPoint.getTarget().getClass().getName(),
                    joinPoint.getSignature().getName(),
                    stopWatch.getTotalTimeMillis());

        }
    }

}
