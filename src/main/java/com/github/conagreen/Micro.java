package com.github.conagreen;

public class Micro {

    private Micro() {
        // prevent to instantiate
    }

    private static class SingletonHolder {
        private static final MicroEngine INSTANCE = new MicroEngine();
    }

    private static MicroEngine getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void get(String path, RequestHandler requestHandler) {
        getInstance().addHandler(path, requestHandler, HttpMethod.GET);
    }

    public static void port(int port) {
        getInstance().configurePort(port);
    }

    public static void run() {
        getInstance().start();
    }
}
