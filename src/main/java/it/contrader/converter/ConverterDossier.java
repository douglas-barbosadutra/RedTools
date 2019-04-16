package it.contrader.converter;




import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DossierDTO;
import it.contrader.model.Dossier;



public class ConverterDossier {
	public static Dossier toEntity(DossierDTO dossierDTO) {

		Dossier dossier = null;
		if (dossierDTO != null) {
			dossier = new Dossier();
			dossier.setIdDossier(dossierDTO.getIdDossier());
			dossier.setPeriodoDiImposta(dossierDTO.getPeriodoDiImposta());
			dossier.setCostoDipendentiPeriodoDiImposta(dossierDTO.getCostoDipendentiPeriodoDiImposta());
			dossier.setFatturatoPeriodoDiImposta(dossierDTO.getFatturatoPeriodoDiImposta());
			dossier.setNumeroTotaleDipendenti(dossierDTO.getNumeroTotaleDipendenti());
			dossier.setTotaleCostiReD(dossierDTO.getTotaleCostiReD());
			dossier.setCostiPersonaleReD(dossierDTO.getCostiPersonaleReD());
			dossier.setTotaleAmmissibile(dossierDTO.getTotaleAmmissibile());
			dossier.setNumeroFornitori(dossierDTO.getNumeroFornitori());
			dossier.setProgetto(ConverterProgetto.toEntity(dossierDTO.getProgettoDTO()));
		}

		return dossier;

	}
	
	
		public static DossierDTO toDTO(Dossier dossier) {

			DossierDTO dossierDTO = null;
			if (dossier != null) {
				dossierDTO= new DossierDTO();
				dossierDTO.setIdDossier(dossier.getIdDossier());
				dossierDTO.setPeriodoDiImposta(dossier.getPeriodoDiImposta());
				dossierDTO.setCostoDipendentiPeriodoDiImposta(dossier.getCostoDipendentiPeriodoDiImposta());
				dossierDTO.setFatturatoPeriodoDiImposta(dossier.getFatturatoPeriodoDiImposta());
				dossierDTO.setNumeroTotaleDipendenti(dossier.getNumeroTotaleDipendenti());
				dossierDTO.setTotaleCostiReD(dossier.getTotaleCostiReD());
				dossierDTO.setCostiPersonaleReD(dossier.getCostiPersonaleReD());
				dossierDTO.setTotaleAmmissibile(dossier.getTotaleAmmissibile());
				dossierDTO.setNumeroFornitori(dossier.getNumeroFornitori());
				dossierDTO.setProgettoDTO(ConverterProgetto.toDTO(dossier.getProgetto()));
				//dossierDTO.setFilledFields(dossierDTO.getFilledFields());
			}
	
			return dossierDTO;
			
			
		}
		
		public static List<DossierDTO> toListDTO(List<Dossier> list) {
			List<DossierDTO> listDossierDTO = new ArrayList<>();
			if (!list.isEmpty()) {
				for (Dossier dossier : list) {
					listDossierDTO.add(ConverterDossier.toDTO(dossier));
				}
			}
			return listDossierDTO;
		}
		
		

		public static List<Dossier> toListEntity(List<DossierDTO> listDossierDTO) {
			List<Dossier> list = new ArrayList<>();
			if (!listDossierDTO.isEmpty()) {
				for (DossierDTO dossierDTO : listDossierDTO) {
					list.add(ConverterDossier.toEntity(dossierDTO));
				}
			}
			return list;
		}
		
}