package br.com.fiap.spring_mvc.controller;

import br.com.fiap.spring_mvc.model.Categoria;
import br.com.fiap.spring_mvc.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {


    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello World!");
        return "hello"; // Nome do template HTML, ex: hello.html
    }

    @GetMapping("/hello2")
    public ModelAndView hello2() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", "Hello fucking  World!");
        return modelAndView;
    }

    @GetMapping("/livro")
    public ModelAndView livro(){
        Livro livro = new Livro();
        livro.setTitulo("Game of Thrones");
        livro.setAutor("George R. R. Martin");
        livro.setCategoria(Categoria.FANTASIA);
        ModelAndView mv = new ModelAndView("livro");
        mv.addObject("livro", livro);
        return mv;
    }
}
