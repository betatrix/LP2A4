package br.edu.ifsp.restaurante.Restaurante.Model;

import br.edu.ifsp.restaurante.Restaurante.dto.PedidoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pedido_prato", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "prato_id"))
    private List<Prato> pratos;

    public Pedido(String descricao, Cliente cliente, List<Prato> pratos) {
        this.descricao = descricao;
        this.cliente = cliente;
        this.pratos = pratos;
    }
}
