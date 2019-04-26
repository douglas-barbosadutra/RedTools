package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterAziendaCliente;
import it.contrader.converter.ConverterImpiegato;
import it.contrader.dao.ImpiegatoRepository;
import it.contrader.dto.AziendaClienteDTO;
import it.contrader.dto.ImpiegatoDTO;
import it.contrader.model.Impiegato;

@Service
public class ImpiegatoService {

	private final ImpiegatoRepository impiegatoRepository;

	@Autowired
	public ImpiegatoService(ImpiegatoRepository impiegatoRepository) {
		this.impiegatoRepository = impiegatoRepository;
	}
	
	public Impiegato getImpiegatoById(Integer id) {
		return impiegatoRepository.findById(id).get();
	}
	
	public ImpiegatoDTO getImpiegatoDTOById(Integer id) {
		return ConverterImpiegato.toDTO(impiegatoRepository.findById(id).get());
	}
	
	public ImpiegatoDTO getByNominativo(String nominativo) {

		final Impiegato impiegato = impiegatoRepository.findByNominativo(nominativo);

		return ConverterImpiegato.toDTO(impiegato);
	}
	
	public Impiegato findImpiegatoByNominativo(String nominativo) {

		final Impiegato impiegato = impiegatoRepository.findByNominativo(nominativo);

		return impiegato;
	}
	public boolean insertImpiegato(ImpiegatoDTO impiegatoDTO) {
		return impiegatoRepository.save(ConverterImpiegato.toEntity(impiegatoDTO)) != null;
	}

	public boolean updateImpiegato(ImpiegatoDTO impiegatoDTO) {
		return impiegatoRepository.save(ConverterImpiegato.toEntity(impiegatoDTO)) != null;
	}
	
	public void deleteImpiegatoById(Integer id) {
		impiegatoRepository.deleteById(id);
	}
	
	public List<ImpiegatoDTO> findImpiegatoDTOByLivello(int livello) {
		
		final List<Impiegato> list = impiegatoRepository.findAllByLivello(livello);
		final List<ImpiegatoDTO> impiegatoDTOs = new ArrayList<>();
		list.forEach(i -> impiegatoDTOs.add(ConverterImpiegato.toDTO(i)));
		return impiegatoDTOs;
	}
	
	public List<ImpiegatoDTO> findImpiegatoDTOByQualifica(String qualifica) {
		
		final List<Impiegato> list = impiegatoRepository.findAllByQualifica(qualifica);
		final List<ImpiegatoDTO> impiegatoDTOs = new ArrayList<>();
		list.forEach(i -> impiegatoDTOs.add(ConverterImpiegato.toDTO(i)));
		return impiegatoDTOs;
	}
	
	public List<ImpiegatoDTO> findImpiegatoDTOByMansione(String mansione) {
		
		final List<Impiegato> list = impiegatoRepository.findAllByMansione(mansione);
		final List<ImpiegatoDTO> impiegatoDTOs = new ArrayList<>();
		list.forEach(i -> impiegatoDTOs.add(ConverterImpiegato.toDTO(i)));
		return impiegatoDTOs;
	}
	
	public List<ImpiegatoDTO> findImpiegatoDTOByTitoloDiStudio(String titoloDiStudio) {
		
		final List<Impiegato> list = impiegatoRepository.findAllByTitoloDiStudio(titoloDiStudio);
		final List<ImpiegatoDTO> impiegatoDTOs = new ArrayList<>();
		list.forEach(i -> impiegatoDTOs.add(ConverterImpiegato.toDTO(i)));
		return impiegatoDTOs;
	}
	
	public List<ImpiegatoDTO> findImpiegatoDTOByAziendaCliente(AziendaClienteDTO aziendaClienteDTO) {
		
		final List<Impiegato> list = impiegatoRepository.findAllByAziendaCliente(ConverterAziendaCliente.toEntity(aziendaClienteDTO));
		final List<ImpiegatoDTO> impiegatoDTOs = new ArrayList<>();
		list.forEach(i -> impiegatoDTOs.add(ConverterImpiegato.toDTO(i)));
		return impiegatoDTOs;
	}

}
