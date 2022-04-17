package com.anderson.agendajsp.controller;

import com.anderson.agendajsp.model.DAO;
import com.anderson.agendajsp.model.Contato;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(urlPatterns = {"Controller", "/main", "/insert", "/select", "/update", "/delete"})
public class Controller extends HttpServlet {
    DAO dao = new DAO();

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
            //todo:verificar exception
//                response.sendRedirect("index.html");
        }
    }

    protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Contato> listaContatos = dao.listarContatos();
        request.setAttribute("contatos", listaContatos);
        RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
        rd.forward(request, response);
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

    protected void listarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Contato contato = new Contato.Build().id(Long.parseLong(id)).create();
        dao.selecionarContato(contato);
        request.setAttribute("id", contato.getId());
        request.setAttribute("nome", contato.getNome());
        request.setAttribute("fone", contato.getFone());
        request.setAttribute("email", contato.getEmail());
        RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
        rd.forward(request, response);

    }

    protected void editarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contato contato = new Contato.Build()
                .id(Long.parseLong(request.getParameter("id")))
                .nome(request.getParameter("nome"))
                .fone(request.getParameter("fone"))
                .email(request.getParameter("email"))
                .create();
        dao.updateContato(contato);
        response.sendRedirect("main");

    }

    protected void deletarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Contato contato = new Contato.Build().id(Long.parseLong(id)).create();
        dao.deletarContato(contato);
        response.sendRedirect("main");

    }

}
