package br.com.fiap.spring_mvc.service;

import br.com.fiap.spring_mvc.dto.LivroRequest;
import br.com.fiap.spring_mvc.model.Livro;
import br.com.fiap.spring_mvc.repository.LivroRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public void cadastrarLivro(LivroRequest livroRequest) {
        Livro livro = requestToLivro(livroRequest);
        livroRepository.save(livro);
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }
    public Livro requestToLivro(LivroRequest livroRequest) {
        Livro livro = new Livro();
        BeanUtils.copyProperties(livroRequest, livro);
        return livro;
    }
}
