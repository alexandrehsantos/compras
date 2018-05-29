package br.com.compras.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.compras.model.Item;
import br.com.compras.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	ItemRepository itemRepository;

	public Item salvar(Item item) {
		return itemRepository.save(item);
	}

	public List<Item> salvar(List<Item> item) {
		return itemRepository.saveAll(item);
	}

	public Collection<Item> buscarTodos() {
		return itemRepository.findAll();
	}

	public void excluir(Item item) {
		itemRepository.delete(item);
	}

	public Item alterar(Item item) {
		return this.salvar(item);
	}

	public Item buscarPorId(Long id) {
		Item item = new Item();
		item.setId(id);
		Example<Item> example = Example.of(item);
		return itemRepository.findOne(example).get();
	}

}
