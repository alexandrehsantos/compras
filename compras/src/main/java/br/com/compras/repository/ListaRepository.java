package br.com.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compras.model.Lista;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Long>{

}
