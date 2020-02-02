package com.modul_120.todo_application.auth;


public class AuthenticationBean {

    private String message;

    @Override
    public String toString() {
        return String.format("HelloWorldBean [messge=%s]", message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AuthenticationBean(String message) {
        this.message = message;
    }
}