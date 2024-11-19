package com.example.trabchoma_2.Controller;
import com.example.trabchoma_2.Model.Tarefa;
import com.example.trabchoma_2.Service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("/filter/{stat}")
    public List<Tarefa> listarPorStatus(@PathVariable int stat){
        return tarefaService.listarPorStatus(stat);
    }

    @GetMapping
    public List<Tarefa> listarTodos(){
        return tarefaService.findAll();
    }

    @GetMapping("/{id}")
    public Tarefa listarById(@PathVariable int id){
        return tarefaService.findById(id);
    }


    @PostMapping
    public Tarefa add(@RequestBody Tarefa tarefa){
        return tarefaService.add(tarefa);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id){
        return tarefaService.delete(id);
    }

    @PutMapping("/status/{id}")
    public Tarefa moverStatus(@PathVariable int id){
        return tarefaService.moverStatus(id);
    }

    @PutMapping("/prioridade/{id}")
    public Tarefa moverPrioridade(@PathVariable int id){
        return tarefaService.moverPrioridade(id);
    }

    @PutMapping("/{id}")
    public Tarefa edit(@PathVariable int id, @RequestBody Tarefa tarefa){
        return tarefaService.editarTarefa(id, tarefa);
    }



}