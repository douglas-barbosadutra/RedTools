package it.contrader.service;

import java.util.ArrayList;
import java.util.List;
import it.contrader.converter.ConverterProgetto;
import it.contrader.converter.ConverterProgetto;
import it.contrader.dao.ProgettoDAO;
import it.contrader.dto.ProgettoDTO;
import it.contrader.dto.ProgettoDTO;
import it.contrader.model.Progetto;
import it.contrader.model.Progetto;

public class ProgettoService {
	
	
private ProgettoDAO progettoDAO;

		public ProgettoService() {
			this.progettoDAO = new ProgettoDAO();
		}


		public List<ProgettoDTO> getAllProgetto() {

			List<Progetto> list = progettoDAO.getAllProgetto();
			List<ProgettoDTO> listDTO = new ArrayList<>();
			for (Progetto progetto : list) {
				listDTO.add(ConverterProgetto.toDTO(progetto));
				
			}

			return listDTO;
		}

		public boolean insertProgetto(ProgettoDTO progettoDTO) {
			return this.progettoDAO.insertProgetto(ConverterProgetto.toEntity(progettoDTO));
		}
		
		public ProgettoDTO readProgetto(int idprogetto) {
			return ConverterProgetto.toDTO(this.progettoDAO.readProgetto(idprogetto));
		}
		
		public boolean updateProgetto(ProgettoDTO progettoDTO) {
			return this.progettoDAO.updateProgetto(ConverterProgetto.toEntity(progettoDTO));
		}
		
		public boolean deleteProgetto(int idprogetto) {
			return this.progettoDAO.deleteProgetto(idprogetto);
		}
		
		
	}

