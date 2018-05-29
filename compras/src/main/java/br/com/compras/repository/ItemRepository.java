package br.com.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compras.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
