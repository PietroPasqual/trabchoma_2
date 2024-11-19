package com.example.trabchoma_2.Service;
import com.example.trabchoma_2.Model.Tarefa;
import com.example.trabchoma_2.Model.Prioridade;
import com.example.trabchoma_2.Model.Status;
import com.example.trabchoma_2.Repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;


@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> findAll() {
        return tarefaRepository.findAll();
    }


    public Tarefa findById(int id) {
        return tarefaRepository.findById(id).orElse(null);
    }


    public List<Tarefa> listarPorStatus(int n_stat) {
        List<Tarefa> listaTarefa = tarefaRepository.findAll();
        List<Tarefa> TarefaPorStatus = new ArrayList<>();

        Status stat = switch (n_stat) {
            case 1 -> Status.Faca;
            case 2 -> Status.Sendo_Feito;
            case 3 -> Status.Pronto;
            default -> null;
        };

        for (Tarefa tarefa : listaTarefa) {
            if(tarefa.getStatus().equals(stat)) {
                TarefaPorStatus.add(tarefa);
            }
        }

        if(TarefaPorStatus.isEmpty()) {
            return null;
        }

        TarefaPorStatus.sort(Comparator.comparing(Tarefa::getPrioridade));
        return TarefaPorStatus;
    }


    public Tarefa add(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }


    public String delete(int id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);
        if(tarefa != null) {
            tarefaRepository.delete(tarefa);
            return "Tarefa foi Excluida:\n\n"+ tarefa;
        }
        return "Tarefa não Existe";
    }


    public Tarefa moverStatus(int id){
        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);
        if (tarefa == null){
            throw new RuntimeException("Tarefa não Existe");
        }
        else{
            switch (tarefa.getStatus()) {
                case Faca -> tarefa.setStatus(Status.Sendo_Feito);
                case Sendo_Feito -> tarefa.setStatus(Status.Pronto);
                default -> tarefa.setStatus(Status.Faca);
            }
            return tarefaRepository.save(tarefa);
        }
    }


    public Tarefa moverPrioridade(int id){
        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);
        if (tarefa == null){
            throw new RuntimeException("Tarefa não Existe");
        }
        else{
            switch (tarefa.getPrioridade()) {
                case Baixa -> tarefa.setPrioridade(Prioridade.Media);
                case Media -> tarefa.setPrioridade(Prioridade.Alta);
                default -> tarefa.setPrioridade(Prioridade.Baixa);
            }
            return tarefaRepository.save(tarefa);
        }
    }


    public Tarefa editarTarefa(int id, Tarefa newStuff){
        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);
        if (tarefa == null){
            throw new RuntimeException("Tarefa nao Existe");
        }
        else{
            if(newStuff.getTitulo() != null){
                tarefa.setTitulo(newStuff.getTitulo());
            }
            if(newStuff.getDescricao() != null){
                tarefa.setDescricao(newStuff.getDescricao());
            }

            return tarefaRepository.save(tarefa);
        }
    }

}