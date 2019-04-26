package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterDossier;
import it.contrader.converter.ConverterImpiegato;
import it.contrader.converter.ConverterPercentualeOreReD;
import it.contrader.dao.PercentualeOreReDRepository;
import it.contrader.dto.DossierDTO;
import it.contrader.dto.ImpiegatoDTO;
import it.contrader.dto.PercentualeOreReDDTO;
import it.contrader.model.Dossier;
import it.contrader.model.Impiegato;
import it.contrader.model.PercentualeOreReD;

@Service
public class PercentualeOreReDService {

	private final PercentualeOreReDRepository percentualeOreReDRepository;

	@Autowired
	public PercentualeOreReDService(PercentualeOreReDRepository percentualeOreReDRepository) {
		this.percentualeOreReDRepository = percentualeOreReDRepository;
	}
	
	public PercentualeOreReD getPercentualeOreReDById(Integer id) {
		return percentualeOreReDRepository.findById(id).get();
	}
	
	public PercentualeOreReDDTO getPercentualeOreReDDTOById(Integer id) {
		return ConverterPercentualeOreReD.toDTO(percentualeOreReDRepository.findById(id).get());
	}
	
	public PercentualeOreReDDTO getPercentualeOreReDDTOByImpiegato(Impiegato impiegato) {
		return ConverterPercentualeOreReD.toDTO(percentualeOreReDRepository.findAllByImpiegato(impiegato).get(0));
	}

	public boolean insertPercentualeOreReD(PercentualeOreReDDTO percentualeOreReDDTO) {
		return percentualeOreReDRepository.save(ConverterPercentualeOreReD.toEntity(percentualeOreReDDTO)) != null;
	}

	public boolean updatePercentualeOreReD(PercentualeOreReDDTO percentualeOreReDDTO) {
		return percentualeOreReDRepository.save(ConverterPercentualeOreReD.toEntity(percentualeOreReDDTO)) != null;
	}
	
	public void deletePercentualeOreReDById(Integer id) {
		percentualeOreReDRepository.deleteById(id);
	}
	
	public List<PercentualeOreReDDTO> findAllPercentualeOreReDDTOByImpiegato(Impiegato impiegato) {
		
		final List<PercentualeOreReD> list = percentualeOreReDRepository.findAllByImpiegato(impiegato);
		final List<PercentualeOreReDDTO> percentualeOreReDDTOs = new ArrayList<>();
		list.forEach(i -> percentualeOreReDDTOs.add(ConverterPercentualeOreReD.toDTO(i)));
		return percentualeOreReDDTOs;
	}
	
	public List<PercentualeOreReDDTO> findPercentualeOreReDDTOByDossier(Dossier dossier) {
		
		final List<PercentualeOreReD> list = percentualeOreReDRepository.findAllByDossier(dossier);
		final List<PercentualeOreReDDTO> percentualeOreReDDTOs = new ArrayList<>();
		list.forEach(i -> percentualeOreReDDTOs.add(ConverterPercentualeOreReD.toDTO(i)));
		return percentualeOreReDDTOs;
	}
	
	public PercentualeOreReDDTO findPercentualeOreReDDTOByImpiegatoAndDossier(ImpiegatoDTO impiegatoDTO, DossierDTO dossierDTO) {
		return ConverterPercentualeOreReD.toDTO(percentualeOreReDRepository.findByImpiegatoAndDossier(ConverterImpiegato.toEntity(impiegatoDTO),
				ConverterDossier.toEntity(dossierDTO)));
	}
	
}
