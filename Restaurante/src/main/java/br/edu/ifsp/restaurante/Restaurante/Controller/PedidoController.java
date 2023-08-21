package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Model.Pedido;
import br.edu.ifsp.restaurante.Restaurante.Model.Prato;
import br.edu.ifsp.restaurante.Restaurante.Repository.CardapioRepository;
import br.edu.ifsp.restaurante.Restaurante.Repository.ClienteRepository;
import br.edu.ifsp.restaurante.Restaurante.Repository.PedidoRepository;
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

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CardapioRepository cardapioRepository;

    List<Pedido> pedidos = new ArrayList<>();

    @GetMapping
    public List<PedidoResponseDTO> getAll() {
        return pedidoRepository.findAll().stream().map(PedidoResponseDTO::new).toList();
    }

    @PostMapping
    public void addPedido(@RequestBody PedidoRequestDTO data){
        List<Prato> p = new ArrayList<>();
        for (Integer id: data.pratos()){
            p.add(cardapioRepository.findById(id).get());
        }
        pedidoRepository.save(new Pedido(data.descricao(), clienteRepository.findBy(data.cliente()).get(), p));
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
