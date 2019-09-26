package com.spring.aspect.interfaces.aspect;

import com.spring.aspect.interfaces.process.GenericProcess;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Attention: Run this test with JVM parameter -javaagent:/path/to/aspectjweaver.jar
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskAspectTest {
  @Autowired
  private GenericProcess genericProcess;

  @Mock
  private Logger mockLogger;
  private Logger originalLogger;

  @Before
  public void setup() {
    originalLogger = TaskAspect.logger;
    TaskAspect.logger = mockLogger;
  }

  @After
  public void cleanup() {
    TaskAspect.logger = originalLogger;
  }

  /**
   * The way TaskAspect is currently implemented, its only side effect is logging output,
   * so the only way we can check if the aspect is executed as expected is to inject a
   * mock logger and verify if it was called as often as expected, i.e. once for each
   * Task1, Task2, Task3, with 1+3 log lines per execution.
   */
  @Test
  public void testAspectExecution() {
    genericProcess.execute();
    verify(mockLogger, times(3)).info(anyString());
    verify(mockLogger, times(9)).info(anyString(), any(Object.class));
  }
}
