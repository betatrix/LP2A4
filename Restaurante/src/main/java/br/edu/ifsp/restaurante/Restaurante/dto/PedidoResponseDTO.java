package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Pedido;

import java.util.List;

public record PedidoResponseDTO(Integer id, String descricao, ClienteResponseDTO cliente, List<CardapioResponseDTO> pratos) {
    public PedidoResponseDTO(Pedido p){
        this(p.getId(), p.getDescricao(), new ClienteResponseDTO(p.getCliente()), p.getPratos().stream().map(CardapioResponseDTO::new).toList());
    }
}
