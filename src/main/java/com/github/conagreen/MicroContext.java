package com.github.conagreen;

public class MicroContext implements Context {

    private final Response response;

    public MicroContext(Response response) {
        this.response = response;
    }

    @Override
    public Response response() {
        return response;
    }
}
