package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    //@RequestMapping(method = RequestMethod.GET, path="/hello")
    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path="/hello")
    public HelloBean hello(){
        return new HelloBean("Hello World");
    }

    @GetMapping(path="/hello/{name}")
    public HelloBean helloName(@PathVariable String name){
        return new HelloBean(String.format("Hello %s!",name));
    }

    @GetMapping(path="hello-internationalized")
//    public String helloInternationalized(@RequestHeader(name = "Accept-Language",required = false) Locale locale){
      public String helloInternationalized(){

//        return messageSource.getMessage("hello.message",null,locale);
        return messageSource.getMessage("hello.message",null, LocaleContextHolder.getLocale());
    }
}
