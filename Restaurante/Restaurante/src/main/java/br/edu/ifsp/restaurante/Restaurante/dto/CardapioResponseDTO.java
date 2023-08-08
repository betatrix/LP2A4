package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Prato;

public record CardapioResponseDTO(Integer id, String nome, String descricao, double preco){

    public CardapioResponseDTO(Prato p){
        this(p.getId(), p.getNome(), p.getDescricao(), p.getPreco());
    }
}
