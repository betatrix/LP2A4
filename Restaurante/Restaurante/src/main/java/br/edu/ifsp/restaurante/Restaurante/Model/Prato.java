package br.edu.ifsp.restaurante.Restaurante.Model;

import br.edu.ifsp.restaurante.Restaurante.dto.CardapioRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.CacheRequest;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Prato {

    private static Integer idBase = 0;
    private Integer id;
    private String nome;
    private String descricao;
    private double preco;

    public Prato(CardapioRequestDTO cardapioRequestDTO){
        this.nome = cardapioRequestDTO.nome();
        this.descricao = cardapioRequestDTO.descricao();
        this.preco = cardapioRequestDTO.preco();
        this.id = idBase++;
    }
}