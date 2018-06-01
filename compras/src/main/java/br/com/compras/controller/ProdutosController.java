package br.com.compras.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.compras.model.Produto;
import br.com.compras.service.ProdutoService;

@Controller
public class ProdutosController {

	@Autowired
	ProdutoService produtoService;

	@RequestMapping(value = "/listaprodutos", method = RequestMethod.GET)
	public ModelAndView litarProdutos() {

		Collection<Produto> allProducts = produtoService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("listaprodutos");
		modelAndView.addObject("produtos", allProducts);
		modelAndView.addObject("produto", new Produto());
		return modelAndView;
	}
}
