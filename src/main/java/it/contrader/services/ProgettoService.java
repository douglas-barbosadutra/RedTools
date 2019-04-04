package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterProgetto;
import it.contrader.dao.ProgettoRepository;
import it.contrader.dto.ProgettoDTO;
import it.contrader.model.AziendaCliente;
import it.contrader.model.Dossier;
import it.contrader.model.Mom;
import it.contrader.model.Progetto;


@Service
public class ProgettoService {
	
	private final ProgettoRepository progettoRepository;
	
	@Autowired
	public ProgettoService(ProgettoRepository ProgettoRepository) {
		this.progettoRepository = ProgettoRepository;
	}

	
	public List<ProgettoDTO> getListaProgettoDTO() {
		return ConverterProgetto.toListDTO((List<Progetto>) progettoRepository.findAll());
	}
	
	
	public ProgettoDTO getProgettoDTOById(Integer id) {
		return ConverterProgetto.toDTO(progettoRepository.findById(id).get());
	}
	
	public ProgettoDTO getProgettoDTOByDossier(Dossier dossier) {
		
		final Progetto progetto = (Progetto) progettoRepository.findByDossier(dossier);
		
		return ConverterProgetto.toDTO(progettoRepository.findByDossier(dossier));
	}
	
	public ProgettoDTO getProgettoDTOByMom(Mom mom) {
		
		final Progetto progetto = (Progetto) progettoRepository.findByMom(mom);
		
		return ConverterProgetto.toDTO(progettoRepository.findByMom(mom));
	}
	
	public boolean insertProgetto(ProgettoDTO ProgettoDTO) {
		return progettoRepository.save(ConverterProgetto.toEntity(ProgettoDTO)) != null;
	}

	public boolean updateProgetto(ProgettoDTO ProgettoDTO) {
		return progettoRepository.save(ConverterProgetto.toEntity(ProgettoDTO)) != null;
	}
	
	public void deleteProgettoByidProgetto(Integer idProgetto) {
		progettoRepository.deleteById(idProgetto);
	}
	
	
public List<ProgettoDTO> findProgettoDTOByidProgetto(int idProgetto) {
		
		final List<Progetto> list = progettoRepository.findAllByidProgetto(idProgetto);
		final List<ProgettoDTO> ProgettoDTOs = new ArrayList<>();
		list.forEach(i -> ProgettoDTOs.add(ConverterProgetto.toDTO(i)));
		return ProgettoDTOs;

		}

public List<ProgettoDTO> findProgettoDTOByAziendaCliente(AziendaCliente aziendacliente) {
	
	final List<Progetto> list = progettoRepository.findAllByAziendaCliente(aziendacliente);
	final List<ProgettoDTO> ProgettoDTOs = new ArrayList<>();
	list.forEach(i -> ProgettoDTOs.add(ConverterProgetto.toDTO(i)));
	return ProgettoDTOs;

	}



}




