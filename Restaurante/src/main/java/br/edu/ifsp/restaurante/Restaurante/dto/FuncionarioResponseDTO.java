package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Funcionario;

public record FuncionarioResponseDTO(Integer id, String nome, String cpf) {
    public FuncionarioResponseDTO(Funcionario f){
        this(f.getId(), f.getNome(), f.getCpf());
    }
}
