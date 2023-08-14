package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Endereco;

public record EnderecoRequestDTO(String rua, String cidade) {

    public EnderecoRequestDTO(Endereco e) {
        this(e.getRua(), e.getCidade());
    }
}
