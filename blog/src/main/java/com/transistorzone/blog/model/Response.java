package com.transistorzone.blog.model;

public class Response {

    private String message;

    private Article body;

    public Response(String message, Article body) {
        this.message = message;
        this.body = body;
    }

    public Response() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Article body) {
        this.body = body;
    }
}
