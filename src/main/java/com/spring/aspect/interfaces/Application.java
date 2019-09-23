package com.spring.aspect.interfaces;

import com.spring.aspect.interfaces.context.Context;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger( Application.class );

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main( String[] args ) {
        ConfigurableApplicationContext context = SpringApplication.run( Application.class, args );
        Process process = context.getBean( Process.class );
        log.info( "jobProcess = {}", process );

        Context jobContext = new Context();


    }
}
