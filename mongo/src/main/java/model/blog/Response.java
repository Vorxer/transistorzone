package model.blog;

import lombok.Data;

@Data
public class Response {

    private String message;

    private Object body;

    public Response(String message, Object body) {
        this.message = message;
        this.body = body;
    }

    public Response() {
    }

}
