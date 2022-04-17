package com.anderson.agendajsp.controller;

import com.anderson.agendajsp.model.regras.RegrasAgenda;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"Controller", "/main", "/insert", "/select", "/update", "/delete"})
public class Controller extends HttpServlet {
    RegrasAgenda regrasAgenda=new RegrasAgenda();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        if (action.equals("/main")) {
            contatos(request, response);
        } else if (action.equals("/insert")) {
            novoContatos(request, response);
        } else if (action.equals("/select")) {
            listarContato(request, response);
        } else if (action.equals("/update")) {
            editarContato(request, response);
        } else if (action.equals("/delete")) {
            deletarContato(request, response);
        } else {
            response.sendRedirect("index.html");
        }
    }


    protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("contatos",regrasAgenda.listarContatos());
        RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
        rd.forward(request, response);
    }

    protected void novoContatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        regrasAgenda.novoContatos(request);
       response.sendRedirect("main");
    }

    protected void listarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request=regrasAgenda.listarContato(request);
        RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
        rd.forward(request, response);

    }

    protected void editarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        regrasAgenda.editarContato(request);
        response.sendRedirect("main");

    }

    protected void deletarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        regrasAgenda.deletarContato(request);
        response.sendRedirect("main");

    }

}
