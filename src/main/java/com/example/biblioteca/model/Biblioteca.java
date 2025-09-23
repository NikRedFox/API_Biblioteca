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
        return id;    }
    public void setId(Long id){
        this.id = id;
    }

    public String getTitulo(){
        return titulo;    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;    }
    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getGenero(){
        return genero;    }
    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getIsbn(){
        return isbn;    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getAno(){
        return ano;    }
    public void setAno(String ano){
        this.ano = ano;
    }

    public Boolean getEmprestimo(){
        return emprestimo;    }
    public void setEmprestimo(Boolean emprestimo){
        this.emprestimo = emprestimo;
    }

    public Boolean getDevolucao(){
        return Biblioteca.this.devolucao;    }
    public void setDevolucao(Boolean devolucao){
        this.devolucao = devolucao;
    }

}

