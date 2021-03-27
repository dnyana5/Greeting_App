package com.firstspringapp.controller;


import com.firstspringapp.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = {"","/","/home"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
    @PostMapping("/post")
    public String greetingPost(@RequestBody Greeting greeting) {
        return greeting.getId() + " " + greeting.getMessage() + "!";
    }
    @PutMapping("/put/{id}")
    public Greeting greeting(@PathVariable("id") int id, @RequestParam(value = "message") String message){
        return  new Greeting(counter.incrementAndGet(),String.format(template, message));
    }

}
