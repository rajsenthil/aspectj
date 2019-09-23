package com.spring.aspect.interfaces.task;

import com.spring.aspect.interfaces.annotation.Provided;
import com.spring.aspect.interfaces.annotation.Required;
import com.spring.aspect.interfaces.annotation.Task;
import com.spring.aspect.interfaces.context.Context;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Task ( name = "Task2", processName = "Generic")
@Required ( values = {"param2"})
@Provided ( values = {"param3"})
@Aspect
public class Task2 {
    Logger logger = LoggerFactory.getLogger( Task2.class.getName() );

    @Around (
        "execution(public com.spring.aspect.interfaces.entity.Job com.spring.aspect.interfaces.process.GenericProcessImpl.process(..)) && " +
        "args(context)"
    )
    public void task( Context context ) {
        String param2 = (String)context.getContextMap().get( "param2" );
        logger.info( "Required Param2 {}", param2 );
        context.getContextMap().put( "param3", "this is parameter 3" );
    }
}
