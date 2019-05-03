package it.contrader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.contrader.model.AziendaCliente;
import it.contrader.model.User;



public interface AziendaClienteRepository extends JpaRepository<AziendaCliente, Integer>{
	
	
	
	public List<AziendaCliente> findAllByUser(User user);
	
	public AziendaCliente findAziendaClientedByCliente(User user);
}
