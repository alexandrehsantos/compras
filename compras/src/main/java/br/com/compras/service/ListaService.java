package br.com.compras.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.compras.model.Lista;
import br.com.compras.repository.ListaRepository;

@Service
public class ListaService {

	@Autowired
	ListaRepository clienteRepository;

	public Lista cadastrar(Lista lista) {
		return clienteRepository.save(lista);
	}

	public Collection<Lista> buscarTodos() {
		return clienteRepository.findAll();
	}

	public void excluir(Lista lista) {
		clienteRepository.delete(lista);
	}

	public Lista alterar(Lista lista) {
		return this.cadastrar(lista);
	}

	public Lista buscarPorId(Long id) {
		Lista item = new Lista();
		item.setId(id);
		Example<Lista> example = Example.of(item);
		return clienteRepository.findOne(example).get();

	}

}
