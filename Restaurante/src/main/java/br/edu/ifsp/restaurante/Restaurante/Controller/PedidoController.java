package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Model.Endereco;
import br.edu.ifsp.restaurante.Restaurante.Model.Pedido;
import br.edu.ifsp.restaurante.Restaurante.Repository.EnderecoRepository;
import br.edu.ifsp.restaurante.Restaurante.Repository.PedidoRepository;
import br.edu.ifsp.restaurante.Restaurante.dto.EnderecoRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.EnderecoResponseDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.PedidoRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.PedidoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    List<Pedido> pedidos = new ArrayList<>();

    @GetMapping
    public List<PedidoResponseDTO> getAll() {
        return pedidoRepository.findAll().stream().map(PedidoResponseDTO::new).toList();
    }

    @PostMapping
    public void addPedido(@RequestBody Pedido pedido){
        pedidoRepository.save(pedido);
    }

    @DeleteMapping("/{id}")
    public void removePedido(@PathVariable Integer id){
        pedidoRepository.deleteById(id);
    }

    @PutMapping
    public void updatePedido(@PathVariable Integer id, @RequestBody PedidoRequestDTO data){
        Pedido p = new Pedido(data);
        p.setId(id);
        pedidoRepository.save(p);
    }
}
