package br.edu.ifsp.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Atividade {
    private static Long idClass = 0L;
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dia;
    private LocalTime hora;

    public Atividade(String nome, String descricao, LocalDate dia, LocalTime hora) {
        this.id = idClass++;
        this.nome = nome;
        this.descricao = descricao;
        this.dia = dia;
        this.hora = hora;
    }

    private List<Participante> participantes;
    public void adicionaParticipante(Participante participante){
        participantes.add(participante);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDia() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dia.format(formatter);
    }

    public String getHora() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return hora.format(formatter);
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }
}

