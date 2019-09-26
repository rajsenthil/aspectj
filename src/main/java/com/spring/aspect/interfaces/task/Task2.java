package com.spring.aspect.interfaces.task;

import com.spring.aspect.interfaces.annotation.Provided;
import com.spring.aspect.interfaces.annotation.Required;
import com.spring.aspect.interfaces.annotation.Task;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Task(name = "Task2", processName = "Generic")
@Required(values = { "param2" })
@Provided(values = { "param3" })
@Aspect
public class Task2 {
  Logger logger = LoggerFactory.getLogger(Task2.class.getName());

  @Before("execution(public void com.spring.aspect.interfaces.process.GenericProcess+.execute())")
  public void task(JoinPoint thisJoinPoint) {
    logger.info("{}", thisJoinPoint);
  }
}
