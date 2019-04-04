package it.contrader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.contrader.model.AziendaCliente;
import it.contrader.model.Impiegato;

public interface ImpiegatoRepository extends JpaRepository<Impiegato, Integer> {

	public Impiegato findByNominativo(String nominativo);
	public List<Impiegato> findAllByLivello(int livello);
	public List<Impiegato> findAllByQualifica(String qualifica);
	public List<Impiegato> findAllByMansione(String mansione);
	public List<Impiegato> findAllByTitoloDiStudio(String titoloDiStudio);
	public List<Impiegato> findAllByAziendaCliente(AziendaCliente aziendaCliente);
}