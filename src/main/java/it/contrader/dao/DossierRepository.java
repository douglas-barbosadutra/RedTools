package it.contrader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.contrader.model.Dossier;
import it.contrader.model.Fattura;
import it.contrader.model.TotaleOreReD;

public interface DossierRepository  extends  JpaRepository<Dossier, Integer>{

	
	
	public List<Dossier> findAllByProgettoAndAziendaCliente(Progetto p, AziendaCliente aC);
	public Dossier findByEsercizios(Fattura fatturas);
	public Dossier findByCostiEsternis(TotaleOreReD totaleOreReDs);
	public List<Dossier> findAllByPeriodoDiImposta(String periodoDiImposta);

}
