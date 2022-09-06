package com.lore.rest.demorestwebservice.service;

import com.lore.rest.demorestwebservice.dto.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/helloWorld")
    public String HelloWorls(){
        return "Hola mort";
    }

    @GetMapping(path = "/helloWorldBean")
    public HelloWorld HelloWorlsBean(){
        return new HelloWorld("HelloWorld");
    }

    @GetMapping(path = "/helloWorldBeanVariable/{name}")
    public HelloWorld HelloWorlsBeanVariable(@PathVariable String name){
        return new HelloWorld("HelloWorld, " + name);
    }
}
