package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Model.Prato;
import br.edu.ifsp.restaurante.Restaurante.Repository.CardapioRepository;
import br.edu.ifsp.restaurante.Restaurante.dto.CardapioRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.CardapioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cardapio")
public class CardapioController {

    @Autowired
    CardapioRepository cardapioRepository;

    List<Prato> pratos = new ArrayList<>();

    @GetMapping
    public List<CardapioResponseDTO> getAll() {
        return cardapioRepository.findAll().stream().map(CardapioResponseDTO::new).toList();
    }

    @PostMapping
    public void addPrato(@RequestBody Prato p){
        cardapioRepository.save(p);
    }

    @DeleteMapping("/{id}")
    public void removePrato(@PathVariable Integer id){
        cardapioRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updatePrato(@PathVariable Integer id, @RequestBody CardapioRequestDTO data){
        Prato p = new Prato(data);
        p.setId(id);
        cardapioRepository.save(p);
    }
}
