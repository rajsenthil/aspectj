package com.spring.aspect.interfaces.context;

import com.spring.aspect.interfaces.annotation.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class Context {
    UUID processId;
    List<Task> tasks;
    Map<Object, Object> contextMap;
}
