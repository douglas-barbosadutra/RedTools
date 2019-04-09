package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterAziendaCliente;
import it.contrader.converter.ConverterMom;
import it.contrader.converter.ConverterProgetto;
import it.contrader.dao.MomRepository;
import it.contrader.dto.AziendaClienteDTO;
import it.contrader.dto.MomDTO;
import it.contrader.dto.ProgettoDTO;
import it.contrader.model.AziendaCliente;
import it.contrader.model.Mom;

@Service
public class MomService {

	private final MomRepository momRepository;

	@Autowired
	public MomService(MomRepository momRepository) {
		this.momRepository = momRepository;
	}
	
	public MomDTO getMomDTOById(Integer id) {
		return ConverterMom.toDTO(momRepository.findById(id).get());
	}
	
	public MomDTO getMomDTOByProgetto(String progettoMom) {
		return ConverterMom.toDTO(momRepository.findByProgettoMom(progettoMom));
	}

	public boolean insertMom(MomDTO momDTO) {
		return momRepository.save(ConverterMom.toEntity(momDTO)) != null;
	}

	public boolean updateMom(MomDTO momDTO) {
		return momRepository.save(ConverterMom.toEntity(momDTO)) != null;
	}
	
	public void deleteMomById(Integer id) {
		momRepository.deleteById(id);
	}
	
	public List<MomDTO> findMomDTOByLuogoMom(String luogoMom) {
		
		final List<Mom> list = momRepository.findAllByLuogoMom(luogoMom);
		final List<MomDTO> momDTOs = new ArrayList<>();
		list.forEach(i -> momDTOs.add(ConverterMom.toDTO(i)));
		return momDTOs;
	}
	
	public List<MomDTO> findMomDTOByDataDelGiornoMom(String dataDelGiornoMom) {
		
		final List<Mom> list = momRepository.findAllByDataDelGiornoMom(dataDelGiornoMom);
		final List<MomDTO> momDTOs = new ArrayList<>();
		list.forEach(i -> momDTOs.add(ConverterMom.toDTO(i)));
		return momDTOs;
	}
	
	public List<MomDTO> findMomDTOByAziendaCliente(AziendaCliente aziendaCliente) {
		
		final List<Mom> list = momRepository.findAllByAziendaCliente(aziendaCliente);
		final List<MomDTO> momDTOs = new ArrayList<>();
		list.forEach(i -> momDTOs.add(ConverterMom.toDTO(i)));
		return momDTOs;
	}
}
