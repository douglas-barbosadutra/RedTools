package it.contrader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.contrader.model.AziendaCliente;
import it.contrader.model.Dossier;
import it.contrader.model.Mom;
import it.contrader.model.Progetto;


public interface ProgettoRepository extends JpaRepository<Progetto, Integer> {
	
	
	public List<Progetto> findAllByidProgetto(int idProgetto);
	public List<Progetto> findAllByAziendaCliente(AziendaCliente aziendaCliente);
    public Progetto findByDossier(Dossier dossier);
    
}


