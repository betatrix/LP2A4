package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Model.Cliente;
import br.edu.ifsp.restaurante.Restaurante.Repository.ClienteRepository;
import br.edu.ifsp.restaurante.Restaurante.dto.ClienteRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.ClienteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    List<Cliente> clientes = new ArrayList<>();

    @GetMapping
    public List<ClienteResponseDTO> getAll() {
        return clienteRepository.findAll().stream().map(ClienteResponseDTO::new).toList();
    }

    @PostMapping
    public void addCliente(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void removeCliente(@PathVariable Integer id){
        clienteRepository.deleteById(id);
    }

    @PutMapping
    public void updateCliente(@PathVariable Integer id,@RequestBody ClienteRequestDTO data){
        Cliente c = new Cliente(data);
        c.setId(id);
        clienteRepository.save(c);
    }
}
