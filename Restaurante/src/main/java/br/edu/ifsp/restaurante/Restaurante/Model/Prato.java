package br.edu.ifsp.restaurante.Restaurante.Model;

import br.edu.ifsp.restaurante.Restaurante.dto.CardapioRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Prato")
@Entity(name = "Prato")
public class Prato {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private double preco;

    @ManyToMany(mappedBy = "pratos", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    public Prato(CardapioRequestDTO data){
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.preco = data.preco();
    }
}