package com.example.demo1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NewCompany", value = "/newCompany")
public class NewCompany extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("Registering a new company.");

        String nameCompany = request.getParameter("name");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Company: " + nameCompany + " Successfully registered. </h1>");
        out.println("</body></html>");

    }
}