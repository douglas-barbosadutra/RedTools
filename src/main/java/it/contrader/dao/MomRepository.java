package it.contrader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.contrader.model.AziendaCliente;
import it.contrader.model.Mom;

public interface MomRepository extends JpaRepository<Mom, Integer> {

	public Mom findByProgettoMom(String progettoMom);
	public List<Mom> findAllByLuogoMom(String luogoMom);
	public List<Mom> findAllByDataDelGiornoMom(String dataDelGiornoMom);
	public List<Mom> findAllByAziendaCliente(AziendaCliente aziendaCliente);
	

}