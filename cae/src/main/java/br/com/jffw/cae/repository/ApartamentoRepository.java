package br.com.jffw.cae.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jffw.cae.models.Apartamento;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Integer>  {

}
