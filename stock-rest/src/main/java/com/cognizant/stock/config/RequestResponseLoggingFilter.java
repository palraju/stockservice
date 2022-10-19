package com.cognizant.stock.config;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@Component
public class RequestResponseLoggingFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        MDC.put("trace-id", UUID.randomUUID().toString());
        MDC.put("uri", req.getRequestURI());
        MDC.put("uri-method", req.getMethod());
        logger.debug("Request received: ");
        chain.doFilter(request, response);
        logger.debug("Response Status:{} ", res.getStatus());
    }

}
