package it.contrader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.contrader.model.Dossier;
import it.contrader.model.Impiegato;
import it.contrader.model.PercentualeOreReD;

public interface PercentualeOreReDRepository  extends  JpaRepository<PercentualeOreReD, Integer>{
	
	public List<PercentualeOreReD> findAllByImpiegato(Impiegato impiegato);
	public List<PercentualeOreReD> findAllByDossier(Dossier dossier);
	public PercentualeOreReD findByImpiegatoAndDossier(Impiegato impiegato, Dossier dossier);
}
