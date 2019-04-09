package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterFattura;
import it.contrader.converter.ConverterMom;
import it.contrader.dao.FatturaRepository;
import it.contrader.dto.FatturaDTO;
import it.contrader.dto.MomDTO;
import it.contrader.model.Dossier;
import it.contrader.model.Fattura;
import it.contrader.model.Fornitore;
import it.contrader.model.Mom;

@Service
public class FatturaService {

	private final FatturaRepository fatturaRepository;

	@Autowired
	public FatturaService(FatturaRepository fatturaRepository) {
		this.fatturaRepository = fatturaRepository;
	}

	public Fattura getFatturaById(Integer id) {
		return fatturaRepository.findById(id).get();
	}
	
	public FatturaDTO getFatturaDTOById(Integer id) {
		return ConverterFattura.toDTO(fatturaRepository.findById(id).get());
	}
	
	public boolean insertFattura(FatturaDTO fatturaDTO) {
		return fatturaRepository.save(ConverterFattura.toEntity(fatturaDTO)) != null;
	}

	public boolean updateFattura(FatturaDTO fatturaDTO) {
		return fatturaRepository.save(ConverterFattura.toEntity(fatturaDTO)) != null;
	}
	
	public void deleteFatturaById(Integer id) {
		fatturaRepository.deleteById(id);
	}
	
	public List<FatturaDTO> findFatturaDTOByDataFattura(String dataFattura) {
		
		final List<Fattura> list = fatturaRepository.findAllByDataFattura(dataFattura);
		final List<FatturaDTO> fatturaDTOs = new ArrayList<>();
		list.forEach(i -> fatturaDTOs.add(ConverterFattura.toDTO(i)));
		return fatturaDTOs;
	}
	
	public List<FatturaDTO> findFatturaDTOByPercentualeAmmissibile(int percentualeAmmissibile) {
		
		final List<Fattura> list = fatturaRepository.findAllByPercentualeAmmissibile(percentualeAmmissibile);
		final List<FatturaDTO> fatturaDTOs = new ArrayList<>();
		list.forEach(i -> fatturaDTOs.add(ConverterFattura.toDTO(i)));
		return fatturaDTOs;
	}
	
	public List<FatturaDTO> findFatturaDTOByDossier(Dossier dossier) {
		
		final List<Fattura> list = fatturaRepository.findAllByDossier(dossier);
		final List<FatturaDTO> fatturaDTOs = new ArrayList<>();
		list.forEach(i -> fatturaDTOs.add(ConverterFattura.toDTO(i)));
		return fatturaDTOs;
	}
	
	public List<FatturaDTO> findFatturaDTOByFornitore(Fornitore fornitore) {
		
		final List<Fattura> list = fatturaRepository.findAllByFornitore(fornitore);
		final List<FatturaDTO> fatturaDTOs = new ArrayList<>();
		list.forEach(i -> fatturaDTOs.add(ConverterFattura.toDTO(i)));
		return fatturaDTOs;
	}
}
