package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Model.Endereco;
import br.edu.ifsp.restaurante.Restaurante.Model.Funcionario;
import br.edu.ifsp.restaurante.Restaurante.Repository.ClienteRepository;
import br.edu.ifsp.restaurante.Restaurante.Repository.EnderecoRepository;
import br.edu.ifsp.restaurante.Restaurante.dto.EnderecoRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.EnderecoResponseDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.FuncionarioRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.FuncionarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    EnderecoRepository enderecoRepository;

    List<Endereco> enderecos = new ArrayList<>();

    @GetMapping
    public List<EnderecoResponseDTO> getAll() {
        return enderecoRepository.findAll().stream().map(EnderecoResponseDTO::new).toList();
    }

    @PostMapping
    public void addEndereco(@RequestBody Endereco endereco){
        enderecoRepository.save(endereco);
    }

    @DeleteMapping("/{id}")
    public void removeEndereco(@PathVariable Integer id){
        enderecoRepository.deleteById(id);
    }

    @PutMapping
    public void updateEndereco(@PathVariable Integer id,@RequestBody EnderecoRequestDTO data){
        Endereco e = new Endereco(data);
        e.setId(id);
        enderecoRepository.save(e);
    }
}
