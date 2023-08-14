package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Cliente;
import br.edu.ifsp.restaurante.Restaurante.Model.Endereco;

public record ClienteRequestDTO(String nome, Endereco endereco) {
    public ClienteRequestDTO(Cliente c){
        this(c.getNome(), c.getEndereco());
    }
}
