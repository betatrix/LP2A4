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

    @DeleteMapping
    public void removePrato(@PathVariable Integer id){
        for (Prato p : pratos) {
            if (p.getId() == null){

            }
        }
    }
    
    @PutMapping
    public void updatePrato(){
        
    }
}
