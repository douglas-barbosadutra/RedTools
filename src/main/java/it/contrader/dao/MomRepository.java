package it.contrader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.contrader.model.AziendaCliente;
import it.contrader.model.Mom;
import it.contrader.model.Progetto;

public interface MomRepository extends JpaRepository<Mom, Integer> {

	public List<Mom> findAllByLuogoMom(String luogoMom);
	public List<Mom> findAllByDataDelGiornoMom(String dataDelGiornoMom);
	public List<Mom> findAllByAziendaCliente(AziendaCliente aziendaCliente);
	public List<Mom> findAllByProgetto(Progetto progetto);
}