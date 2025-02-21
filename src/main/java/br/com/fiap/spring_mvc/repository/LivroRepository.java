package br.com.fiap.spring_mvc.repository;

import br.com.fiap.spring_mvc.model.Categoria;
import br.com.fiap.spring_mvc.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTitulo(String titulo);
    List<Livro> findByAutor(String autor);
    List<Livro> findByCategoria(Categoria categoria);

}
