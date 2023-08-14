package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Cliente;
import br.edu.ifsp.restaurante.Restaurante.Model.Endereco;

public record ClienteResponseDTO(Integer id, String nome, Endereco endereco) {
    public ClienteResponseDTO(Cliente c){
        this(c.getId(), c.getNome(), c.getEndereco());
    }
}
