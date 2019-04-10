package it.contrader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.contrader.model.Dossier;
import it.contrader.model.Impiegato;
import it.contrader.model.TotaleOreReD;

public interface TotaleOreReDRepository  extends  JpaRepository<TotaleOreReD, Integer>{
	
	public List<TotaleOreReD> findAllByImpiegato(Impiegato impiegato);
	public List<TotaleOreReD> findAllByDossier(Dossier dossier);
	public List<TotaleOreReD> findAllByImpiegatoAndDossier(Impiegato impiegato, Dossier dossier);
}
