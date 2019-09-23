package com.spring.aspect.interfaces.task;

import com.spring.aspect.interfaces.annotation.Provided;
import com.spring.aspect.interfaces.annotation.Required;
import com.spring.aspect.interfaces.annotation.Task;
import com.spring.aspect.interfaces.context.Context;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Task( name = "Task1", processName = "Generic")
@Required( values = {"param1"})
@Provided( values = {"param2"})
@Aspect
public class Task1 {

    Logger logger = LoggerFactory.getLogger( Task1.class.getName() );

    @Around (
        "execution(public com.spring.aspect.interfaces.entity.Job com.spring.aspect.interfaces.process.GenericProcessImpl.process(..)) && " +
        "args(context)"
    )
    public void task( Context context ) {
        String param1 = (String)context.getContextMap().get( "param1" );
        logger.info( "Required Param1 {}", param1 );
        context.getContextMap().put( "param2", "this is parameter 2" );
    }
}
