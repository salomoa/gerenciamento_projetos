package com.bn.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_projeto")
public class ProjetoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String nome;
    @Column(name = "data_i")
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() { return dataInicio; }

    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataFim() { return dataFim; }

    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }
}
