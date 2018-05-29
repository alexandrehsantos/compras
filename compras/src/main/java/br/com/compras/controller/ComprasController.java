package br.com.compras.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.compras.model.Item;
import br.com.compras.model.Lista;

@Controller
public class ComprasController {
	private Lista lista;

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String novaLista(Model model) {
		List<Item> listItens = new ArrayList<>();
		lista = new Lista();
		lista.setItems(listItens);
		Item item = new Item();
		model.addAttribute("item", item);
		model.addAttribute("lista", lista);
		return "lista";
	}

	@RequestMapping(value = "/item", method = RequestMethod.POST)
	public ModelAndView novoItem(@ModelAttribute(value = "item") Item item) {
		lista.getItens().add(item);
		System.out.println(item);
		System.out.println(lista);

		return new ModelAndView("item");
	}

}
