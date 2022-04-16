package com.anderson.agendajsp.controller;

import com.anderson.agendajsp.model.DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Controller", value = "/main")
public class Controller extends HttpServlet {
    DAO dao = new DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/main")) {
            contatos(request, response);
        }
    }

    protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("agenda.jsp");
    }

}
