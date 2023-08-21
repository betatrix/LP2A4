package br.edu.ifsp.restaurante.Restaurante.dto;


import java.util.List;

public record PedidoRequestDTO(String descricao, Integer cliente, List<Integer> pratos) {
}
