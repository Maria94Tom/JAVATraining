package org.assignment2.services.aspect;

import org.aspectj.lang.annotation.Around;
import org.slf4j.LoggerFactory;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class MethodLogger {
    private static final Logger logger = LoggerFactory.getLogger(MethodLogger.class);

    @Around("@annotation(org.assignment2.annotation.Loggable)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        Object[] args = joinPoint.getArgs();
        logger.info("Executing method: " + methodName + " with arguments: " + Arrays.toString(args));
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("Execution time: " + (endTime - startTime) + " ms");
        logger.info("Method " + methodName + " returned: " + result);
        if(methodName.equals("deleteEmployee") || !(args.length >0))
        {
            int id = (int) args[0];
            logger.info("Deleted Employee with ID: " + id);
            logger.info("Deleted Employee: " + args[0]);}
        return result;
    }
}
