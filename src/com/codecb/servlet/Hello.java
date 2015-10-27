package com.codecb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Hello")
public class Hello extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        sendHtmlCode(request,response);
//        sendHtml(request,response);
        sendJSON(request, response);

    }

    private void sendHtml(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h3>" + "How you doing?" + "</h3>");
    }

    private void sendJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println("{\"name\":\"Servlet\",\"birthday\":\"1997\"}");
    }

    private void sendHtmlCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.sendError(401, "Need authentication!!!");
    }
}
