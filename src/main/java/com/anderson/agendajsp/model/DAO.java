package com.anderson.agendajsp.model;

import java.sql.Connection;
import java.sql.DriverManager;


public class DAO {

    private  String driver="org.postgresql.Driver";
    private  String url = "jdbc:postgresql:/localhost:5432/dbagenda?useTimezone=UTC";
    private  String user=System.getenv("USER");
    private  String password=System.getenv("PASSWORD");;

    private Connection conectar(){
        Connection conn=null;
        try {
         Class.forName(driver);
         conn= DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;

    }
  }
