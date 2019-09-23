package com.spring.aspect.interfaces.controller;

import com.spring.aspect.interfaces.context.Context;
import com.spring.aspect.interfaces.process.GenericProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping (value="/generic")
public class GenericProcessController {

    private static final Logger logger = LoggerFactory.getLogger( GenericProcessController.class );

    @Autowired GenericProcess genericProcess;

    @RequestMapping (path = "startProcess", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<String> startProcess( @NotNull @RequestBody @Validated Context context ) {
        genericProcess.execute();
        logger.info( "Starting the generic process" );
        return ResponseEntity.ok( "{\"response\": \"Generic process started\"}" );
    }

}
