package br.edu.ifsp.restaurante.Restaurante.Model;

import br.edu.ifsp.restaurante.Restaurante.dto.FuncionarioRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;
    @Column
    private String cpf;

    public Funcionario(FuncionarioRequestDTO data) {
        this.nome = data.nome();
        this.cpf = data.cpf();
    }
}
