package it.contrader.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.config.Task;

import it.contrader.model.Dossier;
import it.contrader.model.User;

public interface DossierRepository  extends  JpaRepository<Dossier, Integer>{

	
	
	public List<Dossier> findAllByProgettoAndAziendaCliente(Progetto p, AziendaCliente aC);
	public Dossier findByEsercizios(Esercizio esercizios);
	public Dossier findByCostiEseternis(CostiEsterni costiEsternis);
}
