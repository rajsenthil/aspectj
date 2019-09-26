package com.spring.aspect.interfaces.aspect;

import com.spring.aspect.interfaces.annotation.Task;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TaskAspect {
  private static final Logger logger = LoggerFactory.getLogger(TaskAspect.class.getName());

  @Around("@within(task) && adviceexecution()")
  public Object groupTasks(ProceedingJoinPoint proceedingJoinPoint, Task task) throws Throwable {
    logger.info("Generalizing the task aspects");
    logger.info("  " + proceedingJoinPoint);
    logger.info("  Task is {}", task.name());
    logger.info("  Process name is {}", task.processName());
    return proceedingJoinPoint.proceed();
  }
}
