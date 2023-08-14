package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Endereco;

public record EnderecoResponseDTO(Integer id, String rua, String cidade) {
    public EnderecoResponseDTO(Endereco e) {
        this(e.getId(), e.getRua(), e.getCidade());
    }
}
