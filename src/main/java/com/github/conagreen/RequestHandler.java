package com.github.conagreen;

@FunctionalInterface
public interface RequestHandler {

    void handle(Context context);
}
