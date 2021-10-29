package com.github.conagreen;

import org.eclipse.jetty.server.Server;

import java.util.HashMap;
import java.util.Map;

public class MicroEngine {
    private Server server;
    private int port = -1;
    private final Map<RequestKey, RequestHandler> handlerMap = new HashMap<>();

    public void configurePort(int port) {
        this.port = port;
    }

    public void start() {
        int serverPort = 8080;
        if (port >= 1) {
            serverPort = port;
        }

        this.server = new Server(serverPort);
        final HttpHandler handler = new HttpHandler(handlerMap);
        this.server.setHandler(handler);

        try {
            this.server.start();
            this.server.join();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void addHandler(String path, RequestHandler requestHandler, HttpMethod method) {
        final RequestKey key = new RequestKey(path, method);
        handlerMap.put(key, requestHandler);
    }
}
