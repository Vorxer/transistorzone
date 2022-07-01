package com.transistorzone.blog.model;

public class Response {

    private String message;

    private Object body;

    public Response(String message, Object body) {
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

    public void setBody(Object body) {
        this.body = body;
    }
}
