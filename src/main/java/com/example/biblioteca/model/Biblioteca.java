package com.example.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name= "biblioteca")

public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

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
        this.isbn = isbn;
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

    public String getTitulo(String titulo){
        return titulo;
    }
    public void setTitulo(){
        this.titulo = titulo;
    }

    public String getAutor(String autor){
        return autor;
    }
    public void setAutor(){
        this.autor = autor;
    }

    public String getGenero(String genero){
        return genero;
    }
    public void setGenero(){
        this.genero = genero;
    }

    public String getIsbn(String isbn){
        return isbn;
    }
    public void setIsbn(){
        this.isbn = isbn;
    }

    public String getAno(String ano){
        return ano;
    }
    public void setAno(){
        this.ano = ano;
    }

    public Boolean getEmprestimo(Boolean emprestimo){
        return emprestimo;
    }
    public void setEmprestimo(){
        this.emprestimo = emprestimo;
    }

    public Boolean getDevolucao(Boolean devolucao){
        return Biblioteca.this.devolucao;
    }
    public void setDevolucao(){
        this.devolucao = devolucao;
    }

}

