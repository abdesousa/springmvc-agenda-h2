package com.devmedia.mvc.agenda.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devmedia.mvc.agenda.entity.Livro;
import com.devmedia.mvc.agenda.repository.LivroRepository;


@Controller
@RequestMapping("/")
public class LivroController {

	private static Logger log = LoggerFactory.getLogger(LivroController.class);

	private LivroRepository livroRepository;

	@Autowired
	public LivroController(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@RequestMapping(value = "/{autor}", method = RequestMethod.GET)
	public String listaLivros(@PathVariable("autor") String autor, Model model) {
		
		log.debug("Passei por aqui");
		
		List<Livro> listaLivros = livroRepository.findByAutor(autor);
		if (listaLivros != null) {
			model.addAttribute("livros", listaLivros);
		}
		return "listaLivros";
	}
	

	@RequestMapping(value = "/{autor}", method = RequestMethod.POST)
	public String adicionaLivroAutor(@PathVariable("autor") String autor, Livro livro) {
		livro.setAutor(autor);
		livroRepository.save(livro);
		return "redirect:/{autor}";
	}
}
