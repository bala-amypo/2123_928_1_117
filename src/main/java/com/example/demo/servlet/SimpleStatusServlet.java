package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(name = "SimpleStatusServlet", urlPatterns = "/status")
public class SimpleStatusServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK);

        try (PrintWriter out = resp.getWriter()) {
            out.print("{");
            out.print("\"status\":\"UP\",");
            out.print("\"timestamp\":\"" + LocalDateTime.now() + "\"");
            out.print("}");
            out.flush();
        }
    }
}
