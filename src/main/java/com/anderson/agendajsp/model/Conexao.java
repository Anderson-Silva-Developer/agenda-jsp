package com.anderson.agendajsp.model;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {

    private  String driver="org.postgresql.Driver";
    private  String url = "jdbc:postgresql://localhost:5432/agendadb?useTimezone=UTC";
    private  String user=System.getenv("USER");
    private  String password=System.getenv("PASSWORD");


    public Connection conectar(){
        Connection conn=null;
        try {
         Class.forName(driver);
         conn= DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            System.out.println("Erro de conexão: "+e.getMessage());
        }
        return conn;

    }
  }
