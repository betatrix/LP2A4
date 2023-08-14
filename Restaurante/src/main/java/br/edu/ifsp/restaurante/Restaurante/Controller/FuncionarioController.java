package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Model.Funcionario;
import br.edu.ifsp.restaurante.Restaurante.Repository.FuncionarioRepository;
import br.edu.ifsp.restaurante.Restaurante.dto.FuncionarioRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.FuncionarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    List<Funcionario> funcionarios = new ArrayList<>();

    @GetMapping
    public List<FuncionarioResponseDTO> getAll() {
        return funcionarioRepository.findAll().stream().map(FuncionarioResponseDTO::new).toList();
    }

    @PostMapping
    public void addFuncionario(@RequestBody Funcionario funcionario){
        funcionarioRepository.save(funcionario);
    }

    @DeleteMapping("/{id}")
    public void removeFuncionario(@PathVariable Integer id){
        funcionarioRepository.deleteById(id);
    }

    @PutMapping
    public void updateFuncionario(@PathVariable Integer id,@RequestBody FuncionarioRequestDTO data){
        Funcionario f = new Funcionario(data);
        f.setId(id);
        funcionarioRepository.save(f);
    }
}
