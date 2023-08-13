package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Funcionario;

public record FuncionarioRequestDTO(String nome, String cpf) {
    public FuncionarioRequestDTO(Funcionario f){
        this(f.getNome(), f.getCpf());
    }
}
