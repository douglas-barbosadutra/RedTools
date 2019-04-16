package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterDossier;
import it.contrader.dao.DossierRepository;
import it.contrader.dto.DossierDTO;
import it.contrader.model.Dossier;
import it.contrader.model.Progetto;

@Service
public class DossierService {
	
	private final DossierRepository dossierRepository;
	
	@Autowired
	public DossierService(DossierRepository dossierRepository) {
		this.dossierRepository = dossierRepository;
	}

	
	public List<DossierDTO> getListaDossierDTO() {
		return ConverterDossier.toListDTO((List<Dossier>) dossierRepository.findAll());
	}
	
	public List<DossierDTO> findDossierDTOByProgetto(Progetto progetto) {
		return ConverterDossier.toListDTO((List<Dossier>) dossierRepository.findAllByProgetto(progetto));
	}
	
	
	public DossierDTO getDossierDTOById(Integer id) {
		return ConverterDossier.toDTO(dossierRepository.getOne(id));
	}
	
	public Dossier getDossierById(Integer id) {
		return dossierRepository.getOne(id);
	}

	 
	
//	
//	public DossierDTO getPeriodoDiImposta(String periodoDiImposta) {
//
//		final Dossier dossier = (Dossier) dossierRepository.findAllByPeriodoDiImposta(periodoDiImposta);
//
//		return ConverterDossier.toDTO(dossier);
//	}
	
	
//	public DossierDTO getfattura(Fattura fattura) {
//
//		final Dossier dossier = (Dossier) dossierRepository.findByFattura(fattura);
//
//		return ConverterDossier.toDTO(dossier);
//	}
	
	
	
	
	
	public boolean insertDossier(DossierDTO dossierDTO) {
		return dossierRepository.save(ConverterDossier.toEntity(dossierDTO)) != null;
	}

	public boolean updateDossier(DossierDTO dossierDTO) {
		return dossierRepository.save(ConverterDossier.toEntity(dossierDTO)) != null;
	}
	
	public void deleteDossierById(Integer id) {
		dossierRepository.deleteById(id);
	}
	
	
public List<DossierDTO> findDossierDTOByPeriodoDiImposta(String periodoDiImposta) {
		
		final List<Dossier> list = dossierRepository.findAllByPeriodoDiImposta(periodoDiImposta);
		final List<DossierDTO> dossierDTOs = new ArrayList<>();
		list.forEach(i -> dossierDTOs.add(ConverterDossier.toDTO(i)));
		return dossierDTOs;
	
	}

}
