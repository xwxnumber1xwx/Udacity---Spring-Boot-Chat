package com.example.mvc_basics.model;

public class ChatForm {

    private String username;
    private String message;
    private String mode;

    public ChatForm() { }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    public String getMode() {
        return mode;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
