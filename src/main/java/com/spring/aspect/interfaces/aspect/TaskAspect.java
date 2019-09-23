package com.spring.aspect.interfaces.aspect;

import com.spring.aspect.interfaces.annotation.Task;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TaskAspect {

    private static final Logger log = LoggerFactory.getLogger( TaskAspect.class.getName() );

    @Around ( "@annotation(com.spring.aspect.interfaces.annotation.Task) && execution(* task(..)) "
              + "&& args(proceedingJoinPoint) && target(task)" )
    public Object groupTasks(
        ProceedingJoinPoint proceedingJoinPoint, Task task ) throws Throwable {
        log.info( "Generalizing the task aspects." );
        log.info( "  " + proceedingJoinPoint );
        log.info( "Task is {}", task.getClass().getName() );
        return proceedingJoinPoint.proceed();
    }
}
