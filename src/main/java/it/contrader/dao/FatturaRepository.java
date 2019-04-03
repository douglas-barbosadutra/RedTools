package it.contrader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.contrader.model.Fattura;
import it.contrader.model.Fornitore;
import it.contrader.model.Dossier;

public interface FatturaRepository extends JpaRepository<Fattura, Integer> {

	public List<Fattura> findAllByDataFattura(String dataFattura);
	public List<Fattura> findAllByPercentualeAmmissibile(int percentualeAmmissibile);
	public List<Fattura> findAllByDossier(Dossier dossier);
	public List<Fattura> findAllByFornitore(Fornitore fornitore);
}