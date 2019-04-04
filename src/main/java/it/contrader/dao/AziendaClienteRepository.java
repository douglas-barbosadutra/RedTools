package it.contrader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.contrader.model.AziendaCliente;



public interface AziendaClienteRepository extends JpaRepository< AziendaCliente, Integer>{
	
	
	public AziendaCliente findByIdAziendaCliente(int idAziendaCliente);
	public List<AziendaCliente> findAllByIdBusinessOwner(int idBusinessOwner);
	
	

}
