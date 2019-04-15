package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterAziendaCliente;
import it.contrader.dao.AziendaClienteRepository;
import it.contrader.dto.AziendaClienteDTO;
import it.contrader.model.AziendaCliente;
import it.contrader.model.User;

	
	@Service
	public class AziendaClienteService {

		private final AziendaClienteRepository aziendaClienteRepository;
		
		@Autowired
		public AziendaClienteService(AziendaClienteRepository aziendaClienteRepository) {
			this.aziendaClienteRepository = aziendaClienteRepository;
		}
		

		public AziendaClienteDTO getAziendaClienteDTOById(Integer id) {
			return ConverterAziendaCliente.toDTO(aziendaClienteRepository.getOne(id));
		}
		public AziendaCliente getAziendaClienteById(Integer id) {
			return aziendaClienteRepository.getOne(id);
		}
		
		
		public List<AziendaClienteDTO> getListaAziendaClienteDTO() {
			return ConverterAziendaCliente.toListDTO((List<AziendaCliente>) aziendaClienteRepository.findAll());
		}
		

		
		
		public List<AziendaClienteDTO> findAziendeClientiDTOByIdUser(int idBO) {
			User user = new User();
			user.setIdUser(idBO);
			final List<AziendaCliente> list = aziendaClienteRepository.findAllByUser(user);
			final List<AziendaClienteDTO> aziendaClienteDTOs = new ArrayList<>();
			list.forEach(i -> aziendaClienteDTOs.add(ConverterAziendaCliente.toDTO(i)));
			return aziendaClienteDTOs;
			}

		
		
		
		public boolean insertAziendaCliente(AziendaClienteDTO aziendaClienteDTO) {
			return aziendaClienteRepository.save(ConverterAziendaCliente.toEntity(aziendaClienteDTO)) != null;
		}

		public boolean updateAziendaCliente(AziendaClienteDTO aziendaClienteDTO) {
			return aziendaClienteRepository.save(ConverterAziendaCliente.toEntity(aziendaClienteDTO)) != null;
		}
		
		public void deleteAziendaClienteByIdAziendaCliente(Integer id) {
			aziendaClienteRepository.deleteById(id);
		}
		
		

}

	
