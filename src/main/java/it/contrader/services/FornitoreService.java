package it.contrader.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterFornitore;
import it.contrader.dao.FornitoreRepository;
import it.contrader.dto.FornitoreDTO;
import it.contrader.model.Fattura;
import it.contrader.model.Fornitore;

@Service
public class FornitoreService {

	private final FornitoreRepository fornitoreRepository;

	@Autowired
	public FornitoreService(FornitoreRepository fornitoreRepository) {
		this.fornitoreRepository = fornitoreRepository;
	}
	
	public List<FornitoreDTO> getAllFornitoreDTO() {
		return ConverterFornitore.toListDTO((List<Fornitore>) fornitoreRepository.findAll());
	}
	public Fornitore getFornitoreById(Integer id) {
		return fornitoreRepository.findById(id).get();
	}
	
	public FornitoreDTO getFornitoreDTOById(Integer id) {
		return ConverterFornitore.toDTO(fornitoreRepository.findById(id).get());
	}
	
	
	public FornitoreDTO getByNomeFornitore(String nomeFornitore) {

		final Fornitore fornitore = fornitoreRepository.findByNomeFornitore(nomeFornitore);

		return ConverterFornitore.toDTO(fornitore);
	}
	
	public FornitoreDTO getByFattura(Fattura fattura) {

		final Fornitore fornitore = fornitoreRepository.findByFattura(fattura);

		return ConverterFornitore.toDTO(fornitore);
	}

	public boolean insertFornitore(FornitoreDTO fornitoreDTO) {
		return fornitoreRepository.save(ConverterFornitore.toEntity(fornitoreDTO)) != null;
	}

	public boolean updateFornitore(FornitoreDTO fornitoreDTO) {
		return fornitoreRepository.save(ConverterFornitore.toEntity(fornitoreDTO)) != null;
	}
	
	public void deleteFornitoreById(Integer id) {
		fornitoreRepository.deleteById(id);
	}
}
