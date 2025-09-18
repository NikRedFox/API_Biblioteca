package com.example.biblioteca.services;

import com.example.biblioteca.BibliotecaApplication;
import com.example.biblioteca.model.Biblioteca;
import com.example.biblioteca.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class BiblioService {
    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public Biblioteca cadastro(Biblioteca titulo){
        return bibliotecaRepository.save(titulo);
    }

    public List<Biblioteca>listar(){
        return bibliotecaRepository.findAll();
    }

    public Biblioteca buscarPorId(Long id){
        Optional<Biblioteca> biblioteca = bibliotecaRepository.findById(id);
        return biblioteca.orElse(null);
    }

    public Biblioteca atualizar(Long id, Biblioteca novosDados){
        Optional<Biblioteca> bibliotecaOptional = bibliotecaRepository.findById(id);
        if(bibliotecaOptional.isPresent()){
            Biblioteca existente = bibliotecaOptional.get();

            existente.setTitulo(novosDados.getTitulo());
            existente.setAutor(novosDados.getAutor());
            existente.setGenero(novosDados.getGenero());
            existente.setIsbn(novosDados.getIsbn());
            existente.setAno(novosDados.getAno());

            return bibliotecaRepository.save(existente);
        }
        else{
            throw new RuntimeException("Livro não encontrado por ID: " + id );
        }
    }

    public void deletarLivro(Long id){
        if(bibliotecaRepository.existsById(id)){
            bibliotecaRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Livro não registrado");
        }
    }

    public Biblioteca emprestarLivro(Long id) {
        Optional<Biblioteca> livroOptional = bibliotecaRepository.findById(id);
        if (livroOptional.isPresent()) {
            Biblioteca livro = livroOptional.get();
            livro.setEmprestimo(true);
            livro.setDevolucao(false);
            return bibliotecaRepository.save(livro);
        } else {
            throw new RuntimeException("Livro não encontrado para empréstimo: " + id);
        }
    }

    public Biblioteca devolverLivro(Long id) {
        Optional<Biblioteca> livroOptional = bibliotecaRepository.findById(id);
        if (livroOptional.isPresent()) {
            Biblioteca livro = livroOptional.get();
            livro.setEmprestimo(false);
            livro.setDevolucao(true);
            return bibliotecaRepository.save(livro);
        } else {
            throw new RuntimeException("Livro não encontrado para devolução: " + id);
        }
    }
}
