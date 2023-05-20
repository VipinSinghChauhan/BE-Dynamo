package com.dynamo.dynamoapp.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CORSFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        httpResponse.addHeader("Access-Control-Allow-Origin", "*");
//        httpResponse.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
//        httpResponse.setHeader("Access-Control-Allow-Headers", "*");
        chain.doFilter(request,httpResponse);
    }
}
