package com.lore.rest.demorestwebservice.service;

import com.lore.rest.demorestwebservice.dto.HelloWorld;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {
    private final MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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

    @GetMapping(path = "/helloWorldInternationalized")
    public String helloWorldInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
}
