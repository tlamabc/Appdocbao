package com.example.appdocbao;
public class Comment {
    private String key;
    private String author;
    private String email;
    private String text;

    public Comment() {
    }

    public Comment(String key, String author, String email, String text) {
        this.key = key;
        this.author = author;
        this.email = email;
        this.text = text;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}