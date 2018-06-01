package br.com.compras.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.compras.model.Produto;
import br.com.compras.service.ProdutoService;

@Controller
public class ProdutosController {

	@Autowired
	ProdutoService produtoService;
	private List<Produto> produtos = new ArrayList<>();

	@RequestMapping(value = "/listaprodutos", method = RequestMethod.GET)
	public ModelAndView litarProdutos() {

		Collection<Produto> allProducts = produtoService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("listaprodutos");
		modelAndView.addObject("produtos", allProducts);
		modelAndView.addObject("carrinhoQtItens", produtos.size());
		modelAndView.addObject("produto", new Produto());
		return modelAndView;
	}

	@RequestMapping(value = "/carrinho", method = RequestMethod.POST)
	public ModelAndView addCarrinho(@ModelAttribute("produto") Produto produto, RedirectAttributes redirectAttributes) {
		produtos.add(produto);
		redirectAttributes.addFlashAttribute("msg", "Produto Adicionado no carrrinho");
		redirectAttributes.addFlashAttribute("carrinhoQtItens", produtos.size());
		return new ModelAndView("redirect:/listaprodutos");

	}

	@RequestMapping(value = "/carrinho", method = RequestMethod.GET)
	public ModelAndView addCarrinho(RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("carrinhoItens", produtos);
		modelAndView.setViewName("carrinho");
		return modelAndView;

	}

}
