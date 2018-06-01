package br.com.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compras.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
