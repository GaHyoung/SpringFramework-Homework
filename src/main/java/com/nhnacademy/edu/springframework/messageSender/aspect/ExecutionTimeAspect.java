package com.nhnacademy.edu.springframework.messageSender.aspect;

import com.nhnacademy.edu.springframework.messageSender.annotation.Auditable;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class ExecutionTimeAspect {

    @Around("@annotation(auditable)")
    public Object sendMessagePointCut(ProceedingJoinPoint joinPoint, Auditable auditable) throws Throwable{
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try{
            Object executionTime = joinPoint.proceed();
            return executionTime;
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
