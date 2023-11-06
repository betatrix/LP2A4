package br.edu.ifsp.repository;

import br.edu.ifsp.model.Atividade;
import br.edu.ifsp.model.Participante;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AtividadeRepository {
    private List<Atividade> atividades = new ArrayList<>();

    public void adicionarAtividade(Atividade atividade){
        atividades.add(atividade);
    }

    public List<Atividade> listarAtividades(){
        Atividade atividade1 = new Atividade("Curso de Java com SpringBoot", "Lorem ipsum dolor sit amet bla", LocalDate.now(), LocalTime.now());
        Atividade atividade2 = new Atividade("Curso de Java com JavaFX", "Lorem ipsum dolor sit amet bla", LocalDate.now(), LocalTime.now());
        Atividade atividade3 = new Atividade("Bootcamp de Java com tristeza e lágrimas", "Lorem ipsum dolor sit amet bla", LocalDate.now(), LocalTime.now());
        atividades.add(atividade1);
        atividades.add(atividade2);
        atividades.add(atividade3);
        return atividades;
    }

    public Atividade buscarAtividade(Long id){
        for(Atividade atividade : atividades){
            if(atividade.getId() == id){
                return atividade;
            }
        }
        return null;
    }

    public void inscreverParticipante(Long id, Participante participante){
        Atividade atividade = buscarAtividade(id);
        atividade.adicionaParticipante(participante);
    }

/*    public void excluirAtividade(Long id){
        if (atividades.isEmpty()) {
            System.out.println("Não há atividades cadastradas para excluir.");
            return;
        } else {
            atividades.remove();
        }
    }*/
}
