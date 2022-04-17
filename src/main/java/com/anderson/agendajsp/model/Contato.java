package com.anderson.agendajsp.model;

import javax.servlet.http.HttpServletRequest;

public class Contato {
    private Long id;
    private String nome;
    private String fone;
    private  String email;

    public Contato() {}

    private Contato(Long id,String nome, String fone, String email) {
        this.id=id;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }
    public static class  Build{
        private Long id;
        private String nome;
        private String fone;
        private  String email;
        public Build(){}
        public Build id(Long id){
            this.id=id;
            return this;
        }
        public Build nome(String nome){
            this.nome=nome;
            return this;
        }
        public Build fone(String fone){
            this.fone=fone;
            return this;
        }
        public Build email(String email){
            this.email=email;
            return this;
        }
        public Contato create(){
            return new Contato(id,nome,fone,email);
        }


    }
    public Contato  Build(HttpServletRequest request){
        Contato contato = new Contato.Build()
                .id(Long.parseLong(request.getParameter("id")))
                .nome(request.getParameter("nome"))
                .fone(request.getParameter("fone"))
                .email(request.getParameter("email"))
                .create();

        return contato;

    }
    public Contato  BuildSemId(HttpServletRequest request){
        Contato contato = new Contato.Build()
                .nome(request.getParameter("nome"))
                .fone(request.getParameter("fone"))
                .email(request.getParameter("email"))
                .create();

        return contato;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
