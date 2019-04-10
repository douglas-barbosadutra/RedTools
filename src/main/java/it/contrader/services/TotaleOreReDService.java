package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterTotaleOreReD;
import it.contrader.dao.TotaleOreReDRepository;
import it.contrader.dto.TotaleOreReDDTO;
import it.contrader.model.Dossier;
import it.contrader.model.Impiegato;
import it.contrader.model.TotaleOreReD;

@Service
public class TotaleOreReDService {

	private final TotaleOreReDRepository totaleOreReDRepository;

	@Autowired
	public TotaleOreReDService(TotaleOreReDRepository totaleOreReDRepository) {
		this.totaleOreReDRepository = totaleOreReDRepository;
	}
	
	public TotaleOreReD getTotaleOreReDById(Integer id) {
		return totaleOreReDRepository.findById(id).get();
	}
	
	public TotaleOreReDDTO getTotaleOreReDDTOById(Integer id) {
		return ConverterTotaleOreReD.toDTO(totaleOreReDRepository.findById(id).get());
	}

	public boolean insertTotaleOreReD(TotaleOreReDDTO totaleOreReDDTO) {
		return totaleOreReDRepository.save(ConverterTotaleOreReD.toEntity(totaleOreReDDTO)) != null;
	}

	public boolean updateTotaleOreReD(TotaleOreReDDTO totaleOreReDDTO) {
		return totaleOreReDRepository.save(ConverterTotaleOreReD.toEntity(totaleOreReDDTO)) != null;
	}
	
	public void deleteTotaleOreReDById(Integer id) {
		totaleOreReDRepository.deleteById(id);
	}
	
	public List<TotaleOreReDDTO> findTotaleOreReDDTOByAziendaCliente(Impiegato impiegato) {
		
		final List<TotaleOreReD> list = totaleOreReDRepository.findAllByImpiegato(impiegato);
		final List<TotaleOreReDDTO> totaleOreReDDTOs = new ArrayList<>();
		list.forEach(i -> totaleOreReDDTOs.add(ConverterTotaleOreReD.toDTO(i)));
		return totaleOreReDDTOs;
	}
	
	public List<TotaleOreReDDTO> findTotaleOreReDDTOByDossier(Dossier dossier) {
		
		final List<TotaleOreReD> list = totaleOreReDRepository.findAllByDossier(dossier);
		final List<TotaleOreReDDTO> totaleOreReDDTOs = new ArrayList<>();
		list.forEach(i -> totaleOreReDDTOs.add(ConverterTotaleOreReD.toDTO(i)));
		return totaleOreReDDTOs;
	}
	
	public List<TotaleOreReDDTO> findTotaleOreReDDTOByImpiegatoAndDossier(Impiegato impiegato, Dossier dossier) {
		
		final List<TotaleOreReD> list = totaleOreReDRepository.findAllByImpiegatoAndDossier(impiegato, dossier);
		final List<TotaleOreReDDTO> totaleOreReDDTOs = new ArrayList<>();
		list.forEach(i -> totaleOreReDDTOs.add(ConverterTotaleOreReD.toDTO(i)));
		return totaleOreReDDTOs;
	}
}
