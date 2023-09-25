package br.edu.ifsp.repository;

import br.edu.ifsp.model.Organizador;

import java.util.ArrayList;
import java.util.List;

public class OrganizadorRepository {
    private List<Organizador> usuarios = new ArrayList<>();

    public void adicionarOrganizador(Organizador organizador){}

    public void buscarIdOrganizador(Long id){}

    public List<Organizador> listarOrganizadores(){
        List<Organizador> organizadores = new ArrayList<>();
        Organizador organizador1 = new Organizador("Beatriz Andrade", "bea@email.com", "bea123");
        Organizador organizador2 = new Organizador("Josué", "josue@email.com", "josu123");
        usuarios.add(organizador1);
        usuarios.add(organizador2);
        return organizadores;
    }
}
