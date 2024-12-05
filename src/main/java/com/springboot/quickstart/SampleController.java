package com.springboot.quickstart;

import com.springboot.quickstart.model.HelloWordBean;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class SampleController {

    // Basically message source is the interface that support internalization of messages
    @Autowired
    MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    String home() {
        return "Hello World!";
    }

    // let us now try to send hello word bean which basically means
    // a bean is an object its just that it is managed by spring so
    @GetMapping(path = "/hello-world-bean")
    HelloWordBean helloWorldBean() {
        // So here basically instead of returning an simple string
        // we are returning and instance or object that is returning  a member varible
        return new HelloWordBean("bean");
    }


    @GetMapping(path = "/hello-world/pathVarible/{name}")
    HelloWordBean helloWorldPathVarible(@PathVariable("name") String name) {
        // So here basically instead of returning an simple string
        // we are returning and instance or object that is returning  a member varible
        return new HelloWordBean("hello, "+name);
    }


    @GetMapping(path = "/hello-world-inter")
    String helloWorldInter() {

        // So this locale statement is helping in getting the current locale
        // the this thread is using and this will be passed to the message source
        // if the message will be available according to the Locale then it will be sended
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",
                locale);
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale );

        //return "Hello World V2";

        //1:
        //2:
//		- Example: `en` - English (Good Morning)
//		- Example: `nl` - Dutch (Goedemorgen)
//		- Example: `fr` - French (Bonjour)
//		- Example: `de` - Deutsch (Guten Morgen)

    }


	
}