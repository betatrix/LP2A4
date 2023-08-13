package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Model.Prato;
import br.edu.ifsp.restaurante.Restaurante.dto.CardapioResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cardapio")
public class CardapioController {
    List<Prato> pratos = new ArrayList<>();

    @GetMapping
    public List<CardapioResponseDTO> getAll() {
        return pratos.stream().map(CardapioResponseDTO::new).toList();
    }

    @PostMapping
    public void addPrato(@RequestBody Prato prato){
        pratos.add(prato);
    }

    @DeleteMapping("/{id}")
    public void removePrato(@PathVariable Integer id){
        for (Prato p : pratos) {
            if (p.getId() == id){
                pratos.remove(p);
            } else {
                System.out.println("ID do prato inválido!");
            }
        }
    }

    @GetMapping("/{id}")
    public Prato findPrato(@PathVariable Integer id) {
        for (Prato p : pratos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    @PutMapping
    public void updatePrato(@RequestBody CardapioResponseDTO cardapioResponseDTO){
        Prato prato = findPrato(cardapioResponseDTO.id());
        if (prato == null) {
            System.out.println("ID do prato inválido!");
        } else {
            prato.setNome(cardapioResponseDTO.nome());
            prato.setDescricao(cardapioResponseDTO.descricao());
            prato.setPreco(cardapioResponseDTO.preco());
        }
    }
}
