package br.com.compras.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.compras.model.Produto;
import br.com.compras.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;

	public Produto salvar(Produto item) {
		return produtoRepository.save(item);
	}

	public List<Produto> salvar(List<Produto> item) {
		return produtoRepository.saveAll(item);
	}

	public Collection<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public void excluir(Produto item) {
		produtoRepository.delete(item);
	}

	public Produto alterar(Produto item) {
		return this.salvar(item);
	}

	public Produto buscarPorId(Long id) {
		Produto item = new Produto();
		item.setId(id);
		Example<Produto> example = Example.of(item);
		return produtoRepository.findOne(example).get();
	}

}
