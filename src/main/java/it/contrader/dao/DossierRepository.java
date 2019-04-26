package it.contrader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.contrader.model.Dossier;
import it.contrader.model.Progetto;

public interface DossierRepository  extends  JpaRepository<Dossier, Integer>{

	
	public List<Dossier> findAllByPeriodoDiImposta(String periodoDiImposta);
	public List<Dossier> findAllByProgetto(Progetto progetto);
}
  