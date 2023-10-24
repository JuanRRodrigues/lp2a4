package com.example.demo1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/listCompanies")
public class ListCompany extends HelloServlet {

    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


      Database database = new Database();
        List<Company> companies = database.getCompanies();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<ul>");
        for (Company company : companies){
            out.println("<li>" + company.getName() + "</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }
}
