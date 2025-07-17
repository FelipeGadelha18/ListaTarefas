package com.example.tarefa.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Todo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(nullable = false)
    private LocalDateTime criarAT;

    @Column(nullable = false)
    private LocalDate dataFinal;

    @Column(nullable = true)
    private LocalDate finalAt;




    public Todo(){
        this.criarAT = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getCriarAT() {
        return criarAT;
    }

    public void setCriarAT(LocalDateTime criarAT) {
        this.criarAT = criarAT;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public LocalDate getFinalAt() {
        return finalAt;
    }

    public void setFinalAt(LocalDate finalAt) {
        this.finalAt = finalAt;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Todo other = (Todo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", titulo=" + titulo + "]";
    }
    
    
    

}
