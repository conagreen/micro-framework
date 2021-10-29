package com.github.conagreen;

public class Application {

    public static void main(String[] args) {
        Micro.get("/hello", ctx -> {
            ctx.response().text("Hello, Framework!");
        });
        Micro.port(12345);
        Micro.run();
    }
}