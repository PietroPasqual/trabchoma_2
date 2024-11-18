package com.example.trabchoma_2.Model;
import jakarta.persistence.*;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String titulo;
    private String descricao;
    private String data_criacao;
    private String status = "A fazer";
    private String prioridade;



    public int getId() {
        return id;
    }

    
    public String getStatus() {
        return status;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData_criacao() {
        return data_criacao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }


    @Override
    public String toString(){
        return "Tarefa {" +
                "\n\tid = " + id +
                "\n\tTitulo = " + titulo +
                "\n\tDescricao = " + descricao +
                "\n\tData de criacao = " + data_criacao +
                "\n\tStatus = " + status +
                "\n\tPrioridade = " + prioridade +
                "\n}";
    }

}
