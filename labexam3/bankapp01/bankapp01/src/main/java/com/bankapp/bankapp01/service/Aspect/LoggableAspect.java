package com.bankapp.bankapp01.service.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LoggableAspect {
    private Logger logger=org.slf4j.LoggerFactory.getLogger(LoggableAspect.class);
   @Around("@annotation(com.bankapp.bankapp01.service.Aspect.Loggabel()")
    public Object loggable(ProceedingJoinPoint joinPoint) throws Throwable {
       logger.info("Executing {}",joinPoint.getSignature());
       Long startTime=System.currentTimeMillis();
       Object proceed=joinPoint.proceed();
       Long endTime=System.currentTimeMillis();
       logger.info("Executed {} in {} ms",joinPoint.getSignature(),endTime-startTime);
       return proceed;

   }



    }

