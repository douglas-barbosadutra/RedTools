package it.contrader.converter;

import it.contrader.dto.MomDTO;

import it.contrader.model.Mom;

public class ConverterMom {

	
	public static MomDTO toDTO(Mom mom) {
		MomDTO momDTO = null;
		if (mom != null) {
			momDTO = new MomDTO();
			momDTO.setId_mom(mom.getId_mom());
			momDTO.setNome_utente_finale_mom(mom.getNome_utente_finale_mom());
			momDTO.setLuogo_mom(mom.getLuogo_mom());
			momDTO.setData_del_giorno_mom(mom.getData_del_giorno_mom());
			momDTO.setOrario_mom(momDTO.getOrario_mom());
			momDTO.setOggetto_mom(momDTO.getOggetto_mom());
			momDTO.setProgetto_mom(momDTO.getProgetto_mom());
			momDTO.setPartecipanti_mom(momDTO.getPartecipanti_mom());
			momDTO.setTesto_agenda_mom(momDTO.getTesto_agenda_mom());
			momDTO.setTesto_azione_mom(momDTO.getTesto_azione_mom());
			momDTO.setTesto_note_mom(momDTO.getTesto_note_mom());
			momDTO.setChiave_est_ut_fin(momDTO.getChiave_est_ut_fin());
			
			}
		return momDTO;
	}
	
	public static Mom toEntity(MomDTO momDTO) {
		Mom mom = null;
		if (momDTO != null) {
			mom = new Mom();
			mom.setId_mom(momDTO.getId_mom());
			mom.setNome_utente_finale_mom(momDTO.getNome_utente_finale_mom());
			mom.setLuogo_mom(momDTO.getLuogo_mom());
			mom.setData_del_giorno_mom(momDTO.getData_del_giorno_mom());
			mom.setOrario_mom(momDTO.getOrario_mom());
			mom.setOggetto_mom(momDTO.getOggetto_mom());
			mom.setProgetto_mom(momDTO.getProgetto_mom());
			mom.setPartecipanti_mom(momDTO.getPartecipanti_mom());
			mom.setTesto_agenda_mom(momDTO.getTesto_agenda_mom());
			mom.setTesto_azione_mom(momDTO.getTesto_azione_mom());
			mom.setTesto_note_mom(momDTO.getTesto_note_mom());
			mom.setChiave_est_ut_fin(momDTO.getChiave_est_ut_fin());
			
			}
		return mom;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
