package com.anderson.agendajsp.model;

public class Contato {
    private int id;
    private String nome;
    private String fone;
    private  String email;

    public Contato() {}

    private Contato(String nome, String fone, String email) {
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }
    public static class  Build{
        private int id;
        private String nome;
        private String fone;
        private  String email;
        public Build(){}
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
            return new Contato(nome,fone,email);
        }


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
