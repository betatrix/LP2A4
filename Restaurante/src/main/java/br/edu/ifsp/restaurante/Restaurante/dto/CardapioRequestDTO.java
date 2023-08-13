package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Prato;

public record CardapioRequestDTO(String nome, String descricao, double preco) {
    public CardapioRequestDTO(Prato p){
        this(p.getNome(), p.getDescricao(), p.getPreco());
    }
}
