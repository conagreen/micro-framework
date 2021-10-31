package com.github.conagreen;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.session.SessionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.Map;

// 스프링의 DispatcherServlet 모사한 모듈
public class DispatcherHandler extends SessionHandler {

    private final Map<RequestKey, RequestHandler> handlerMap;

    public DispatcherHandler(Map<RequestKey, RequestHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public void doHandle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String path = request.getRequestURI();
        final HttpMethod httpMethod = HttpMethod.valueOf(request.getMethod());
        final RequestKey key = new RequestKey(path, httpMethod);

        final RequestHandler handler = handlerMap.get(key);

        final HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(response);
        final MicroResponse microResponse = new MicroResponse(responseWrapper);
        final Context context = new MicroContext(microResponse);

        handler.handle(context);
        baseRequest.setHandled(handler != null);
    }
}
