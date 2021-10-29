package com.github.conagreen;

import java.util.Objects;

public class RequestKey {

    private final String path;
    private final HttpMethod method;

    public RequestKey(String path, HttpMethod method) {
        this.path = path;
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestKey that = (RequestKey) o;
        return Objects.equals(path, that.path) && method == that.method;
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, method);
    }
}
