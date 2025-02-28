package br.com.fiap.spring_mvc.controller;

import br.com.fiap.spring_mvc.dto.LivroRequest;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.spring_mvc.service.LivroService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/livro")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/cadastro")
    public ModelAndView livroCadastro() {
        ModelAndView mv = new ModelAndView("livroCadastro");
        mv.addObject("livroRequest", new LivroRequest());
        return mv;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrarLivro(LivroRequest livroRequest) {
        livroService.cadastrarLivro(livroRequest);
        return new ModelAndView("redirect:/livro/lista");
    }

    @GetMapping("/lista")
    public ModelAndView listaLivros() {
        ModelAndView mv = new ModelAndView("listaLivros");
        mv.addObject("livros", livroService.listarLivros());
        return mv;
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return new ModelAndView("redirect:/livro/lista");
    }

    @PostMapping("/atualizar")
    public ModelAndView atualizarLivro(LivroRequest livroRequest) {
        livroService.atualizarLivro(livroRequest);
        return new ModelAndView("redirect:/livro/lista");
    }
}
