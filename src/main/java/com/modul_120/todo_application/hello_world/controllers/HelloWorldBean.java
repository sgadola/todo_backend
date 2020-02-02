package com.modul_120.todo_application.hello_world.controllers;


public class HelloWorldBean {

    private String message;


    public HelloWorldBean(String message) {
        this.message = message;
    }

    // Getter and setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("HelloWorldBean [messge=%s]", message);
    }
}