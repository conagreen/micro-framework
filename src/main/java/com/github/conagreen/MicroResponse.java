package com.github.conagreen;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MicroResponse implements Response{

    private final HttpServletResponse responseWrapper;

    public MicroResponse(HttpServletResponse responseWrapper) {
        this.responseWrapper = responseWrapper;
    }

    @Override
    public void text(String text) {
        responseWrapper.setStatus(200);
        responseWrapper.setContentType("text/plain;");
        try {
            final OutputStream os = responseWrapper.getOutputStream();
            os.write(text.getBytes(StandardCharsets.UTF_8));
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();;
        }
    }
}
