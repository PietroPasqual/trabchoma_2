package com.example.trabchoma_2.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String titulo;

    private String descricao;
    private Status status;
    private Prioridade prioridade;

    private LocalDate data_criacao;

    public Tarefa(){
        this.status = Status.Faca;
        this.prioridade = Prioridade.Baixa;

        this.data_criacao = LocalDate.now();
    }


    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Status getStatus() {
        return status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public String getTitulo() {
        return titulo;
    }



    public String getData_criacao() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.data_criacao.format(formatter);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public String toString(){
        return "Tarefa {" +
                "\n\tid = " + id +
                "\n\tTitulo = " + titulo +
                "\n\tDescricao = " + descricao +
                "\n\tData de criacao = " + getData_criacao() +
                "\n\tStatus = " + status +
                "\n\tPrioridade = " + prioridade +
                "\n}";
    }
}