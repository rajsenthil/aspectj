package com.spring.aspect.interfaces.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GenericProcessImpl implements GenericProcess {
    Logger logger = LoggerFactory.getLogger( GenericProcessImpl.class.getName() );

    @Override
    public void execute() {
        logger.info( "Generic Process execution is invoked" );
    }
}
