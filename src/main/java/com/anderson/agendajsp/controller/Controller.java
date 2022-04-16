package com.anderson.agendajsp.controller;

import com.anderson.agendajsp.model.DAO;
import com.anderson.agendajsp.model.Contato;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"Controller", "/main", "/insert"})
public class Controller extends HttpServlet {
    DAO dao = new DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        if (action.equals("/main")) {
            contatos(request, response);
        }
        if (action.equals("/insert")) {
            novoContatos(request, response);
        }
        //todo:verificar exception
//        else {
//            response.sendRedirect("index.html");
//        }

    }

    protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("agenda.jsp");
    }

    protected void novoContatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contato contato = new Contato.Build()
                .nome(request.getParameter("nome"))
                .fone(request.getParameter("fone"))
                .email(request.getParameter("email"))
                .create();
        dao.inserirContato(contato);
        response.sendRedirect("main");


    }

}
