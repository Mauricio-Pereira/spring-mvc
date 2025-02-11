package br.com.fiap.spring_mvc.repository;

import br.com.fiap.spring_mvc.model.Livro;

import java.util.List;

public interface LivroRepository {
    List<Livro> findAll();
    Livro findById(Long id);
    void save(Livro livro);
    void deleteById(Long id);
}
