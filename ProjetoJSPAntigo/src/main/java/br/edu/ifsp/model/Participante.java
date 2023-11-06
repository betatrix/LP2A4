package br.edu.ifsp.model;

public class Participante {
    private static Long idClass = 0L;
    private Long id;
    private String nome;

    public Participante(String nome) {
        this.id = idClass++;
        this.nome = nome;
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
}
