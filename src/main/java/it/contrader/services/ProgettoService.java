package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterProgetto;
import it.contrader.dao.ProgettoRepository;
import it.contrader.dto.ProgettoDTO;
import it.contrader.model.AziendaCliente;
import it.contrader.model.Progetto;


@Service
public class ProgettoService {
	
	private final ProgettoRepository ProgettoRepository;
	
	@Autowired
	public ProgettoService(ProgettoRepository ProgettoRepository) {
		this.ProgettoRepository = ProgettoRepository;
	}

	
	public List<ProgettoDTO> getListaProgettoDTO() {
		return ConverterProgetto.toListDTO((List<Progetto>) ProgettoRepository.findAll());
	}
	
	
	public ProgettoDTO getProgettoDTOById(Integer id) {
		return ConverterProgetto.toDTO(ProgettoRepository.findById(id).get());
	}
	
	
	
	

	
	public boolean insertProgetto(ProgettoDTO ProgettoDTO) {
		return ProgettoRepository.save(ConverterProgetto.toEntity(ProgettoDTO)) != null;
	}

	public boolean updateProgetto(ProgettoDTO ProgettoDTO) {
		return ProgettoRepository.save(ConverterProgetto.toEntity(ProgettoDTO)) != null;
	}
	
	public void deleteProgettoByidProgetto(Integer idProgetto) {
		ProgettoRepository.deleteById(idProgetto);
	}
	
	
public List<ProgettoDTO> findProgettoDTOByPeriodoDiImposta(String periodoDiImposta) {
		
		
		final List<ProgettoDTO> ProgettoDTOs = new ArrayList<>();
		
		return ProgettoDTOs;
	
	}

public List<ProgettoDTO> findProgettoDTOByProgetto(Progetto progetto) {
	
//	final List<Progetto> list = ProgettoRepository.findAllByidProgetto(idprogetto);
	final List<ProgettoDTO> ProgettoDTOs = new ArrayList<>();
//	list.forEach(i -> ProgettoDTOs.add(ConverterProgetto.toDTO(i)));
	return ProgettoDTOs;

}

public List<ProgettoDTO> findProgettoDTOByAziendaCliente(AziendaCliente aziendaCliente) {
	
	//final List<Progetto> list = ProgettoRepository.findAllByAziendaCliente(aziendaCliente);
	final List<ProgettoDTO> ProgettoDTOs = new ArrayList<>();
//	list.forEach(i -> ProgettoDTOs.add(ConverterProgetto.toDTO(i)));
	return ProgettoDTOs;

}

}




