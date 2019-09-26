package com.spring.aspect.interfaces.task;

  import com.spring.aspect.interfaces.annotation.Required;
  import com.spring.aspect.interfaces.annotation.Task;
  import org.aspectj.lang.JoinPoint;
  import org.aspectj.lang.annotation.Aspect;
  import org.aspectj.lang.annotation.Before;
  import org.slf4j.Logger;
  import org.slf4j.LoggerFactory;

@Task(name = "Task3", processName = "Generic")
@Required(values = { "param1", "param2" })
@Aspect
public class Task3 {
    Logger logger = LoggerFactory.getLogger(Task3.class.getName());

    @Before("execution(public void com.spring.aspect.interfaces.process.GenericProcess+.execute())")
    public void task(JoinPoint thisJoinPoint) {
        logger.info("{}", thisJoinPoint);
    }
}
