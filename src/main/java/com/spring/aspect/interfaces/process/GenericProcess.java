package com.spring.aspect.interfaces.process;

import com.spring.aspect.interfaces.annotation.Process;
import com.spring.aspect.interfaces.annotation.execute;

@Process( name = "Generic")
public interface GenericProcess {

    @execute
    void execute();
}
