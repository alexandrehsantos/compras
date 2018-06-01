package br.com.compras.converters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import br.com.compras.model.Produto;
import br.com.compras.service.ProdutoService;

@Service
public class ProdutoConverter implements Formatter<Produto> {

	@Autowired
	ProdutoService produtoService;

	@Override
	public String print(Produto object, Locale arg1) {
		return (object != null ? object.getId().toString() : "");
	}

	@Override
	public Produto parse(String string, Locale arg1) throws ParseException {
		Long id = Long.valueOf(string);
		return this.produtoService.buscarPorId(id);
	}

}
