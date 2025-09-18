package com.example.biblioteca.Controller;

import com.example.biblioteca.model.Biblioteca;
import com.example.biblioteca.services.BiblioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/biblioteca")

public class BiblioController {
    @Autowired
    private BiblioService service;

    @PostMapping("/livros")
    public ResponseEntity<Biblioteca> cadastro(@RequestBody Biblioteca titulo){
        Biblioteca tituloRegistrado = service.cadastro(titulo);
        return new ResponseEntity<>(tituloRegistrado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Biblioteca>>Lista(){
        List<Biblioteca> titulo = service.listar();
        return new ResponseEntity<>(titulo, HttpStatus.OK);
    }

    @GetMapping("/livros/{id}")
    public ResponseEntity<Biblioteca>buscarPorId(@PathVariable Long id){
        Biblioteca titulo = service.buscarPorId(id);
        return titulo != null
                ? new ResponseEntity<>(titulo, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/livros/{id}")
    public ResponseEntity<Biblioteca> atualizar(@PathVariable Long id, @RequestBody Biblioteca novosDados){
        try{
            Biblioteca atualizado = service.atualizar(id, novosDados);
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/livros/{id}/emprestimo")
    public ResponseEntity<Biblioteca> emprestarLivro(@PathVariable Long id) {
        try {
            Biblioteca atualizado = service.emprestarLivro(id);
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/livros/{id}/devolucao")
    public ResponseEntity<Biblioteca> devolverLivro(@PathVariable Long id) {
        try {
            Biblioteca atualizado = service.devolverLivro(id);
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/livros/{id}/deletar")
    public ResponseEntity<Void>deletar(@PathVariable Long id){
        try{
            service.deletarLivro(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
