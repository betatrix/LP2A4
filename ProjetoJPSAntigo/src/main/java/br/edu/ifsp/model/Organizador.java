package br.edu.ifsp.model;

public class Organizador {

    private static Long idClass = 0L;
    private Long id;
    private String nome;
    private String email;
    private String senha;

    public Organizador(String nome, String email, String senha) {
        this.id = idClass++;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }


}
