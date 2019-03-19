package main.service;

import main.converter.InstructionConverter;
import main.dao.InstructionDAO;
import main.dto.InstructionDTO;
import main.model.Instruction;

import java.util.*;

public class InstructionService {
	
	private InstructionDAO istruzioneDAO;
	
	public InstructionService() {
		this.istruzioneDAO = new InstructionDAO();
	}
	
	public List<InstructionDTO> getAllIstruzioni(int idTask){
		List<Instruction> istruzioni = this.istruzioneDAO.getAllIstruzioni(idTask);
		List<InstructionDTO> istruzioniDTO = new ArrayList<>();
		for(Instruction istruzione: istruzioni) {
			istruzioniDTO.add(InstructionConverter.convertToDto(istruzione));
		}
		return istruzioniDTO;
	}
	
	public boolean insertIstruzione(InstructionDTO istruzionedto, int idTask) {
		return this.istruzioneDAO.insertIstruzione(InstructionConverter.convertToIstruzione(istruzionedto, idTask));
	}
	
	public boolean deleteIstruzione(String nome, int idTask) {
		return this.istruzioneDAO.deleteIstruzione(nome, idTask);
	}
	
	public boolean modifyIstruzione(InstructionDTO istruzionedto, int idTask) {
		return this.istruzioneDAO.modifyIstruzione(InstructionConverter.convertToIstruzione(istruzionedto, idTask));
	}
}
