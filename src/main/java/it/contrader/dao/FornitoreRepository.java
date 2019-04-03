package it.contrader.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.contrader.model.Fattura;
import it.contrader.model.Fornitore;

public interface FornitoreRepository extends JpaRepository<Fornitore, Integer> {

	public Fornitore findByNomeFornitore(String nomeFornitore);
	public Fornitore findByFattura(Fattura fattura);
}