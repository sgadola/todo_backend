package com.modul_120.todo_application.hello_world.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("http://localhost:4200")
public class HelloWorldController {

    // GET
    // URI - /hello-world
    // Method - "Hello World"
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello cruel World :(";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean HelloWorldBean() {
        return new HelloWorldBean("Hello even more cruel World ;_;");
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathvariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello to the damn cruel World, %s ;-.-;", name));
    }
}