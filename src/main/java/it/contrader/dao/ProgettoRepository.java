package it.contrader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.contrader.model.Progetto;


public interface ProgettoRepository extends JpaRepository<Progetto, Integer> {
	
	public Progetto findProgettoByidProgetto(int idProgetto);
	public List<Progetto> findAllByidProgetto(int idProgetto);
	
}


