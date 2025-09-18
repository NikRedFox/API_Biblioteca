package com.example.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name= "biblioteca")

public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String ano;

    @Column(nullable = false)
    private Boolean emprestimo;

    @Column(nullable = false)
    private Boolean devolucao;

    public Biblioteca(){

    }

    public Biblioteca(String titulo, String autor, String genero, String isbn,
                      String ano, Boolean emprestimo, Boolean devolucao){
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.isnb = isbn;
        this.ano = ano;
        this.emprestimo = emprestimo;
        this.devolucao = devolucao;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
}
