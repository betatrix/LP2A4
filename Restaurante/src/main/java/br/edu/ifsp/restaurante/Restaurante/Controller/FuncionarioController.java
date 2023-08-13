package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Model.Funcionario;
import br.edu.ifsp.restaurante.Restaurante.dto.FuncionarioResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
    List<Funcionario> funcionarios = new ArrayList<>();

    @GetMapping
    public List<FuncionarioResponseDTO> getAll() {
        return funcionarios.stream().map(FuncionarioResponseDTO::new).toList();
    }

    @PostMapping
    public void addFuncionario(@RequestBody Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    @DeleteMapping("/{id}")
    public void removeFuncionario(@PathVariable Integer id){
        for (Funcionario f : funcionarios) {
            if (f.getId() == id){
                funcionarios.remove(f);
            } else {
                System.out.println("ID do prato inválido!");
            }
        }
    }

    @GetMapping("/{id}")
    public Funcionario findFuncionario(@PathVariable Integer id) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    @PutMapping
    public void updateFuncionario(@RequestBody FuncionarioResponseDTO funcionarioResponseDTO){
        Funcionario funcionario = findFuncionario(funcionarioResponseDTO.id());
        if (funcionario == null) {
            System.out.println("ID do prato inválido!");
        } else {
            funcionario.setNome(funcionarioResponseDTO.nome());
            funcionario.setCpf(funcionarioResponseDTO.cpf());
        }
    }
}
