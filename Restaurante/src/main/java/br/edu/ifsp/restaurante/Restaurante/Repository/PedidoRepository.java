package br.edu.ifsp.restaurante.Restaurante.Repository;

import br.edu.ifsp.restaurante.Restaurante.Model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
