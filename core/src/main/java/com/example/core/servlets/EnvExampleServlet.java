package com.example.core.servlets;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Modified;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(
    service = Servlet.class,
    property = {
        "sling.servlet.paths=/bin/envexample"
    },
    scope = ServiceScope.SINGLETON
)
public class EnvExampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        String envValue = System.getenv("MY_ENV_VAR");
        resp.setContentType("text/plain");
        resp.getWriter().write("Environment Variable Value: " + envValue);
    }
}