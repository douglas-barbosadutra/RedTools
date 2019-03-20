package it.contrader.converter;

import it.contrader.dto.DossierDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Dossier;
import it.contrader.model.User;



public class ConverterDossier {
	
	
		public static DossierDTO toDTO(Dossier dossier) {
			DossierDTO dossierDTO = null;
			if(dossier != null ) {
				dossierDTO = new DossierDTO();
				dossierDTO.setCostoDipendenti(dossier.getCostoDipendenti());
				dossierDTO.setFatturatoPeriodoDiImposta(dossier.getFatturatoPeriodoDiImposta());
				dossierDTO.setNumeroDipendenti(dossier.getNumeroDipendenti());
				dossierDTO.setCostiAttivitaRd(dossier.getCostiAttivitaRd());
				dossierDTO.setCostiPersonaleRd(dossier.getCostiPersonaleRd());
				dossierDTO.setPartitaIva(dossier.getPartitaIva());
				dossierDTO.setIdProgetto(dossier.getIdProgetto());
				dossierDTO.setIdDossier(dossier.getIdDossier());
				dossierDTO.setPeriodoImposta(dossier.getFatturatoPeriodoDiImposta());
			}
			return dossierDTO;
		
			
		}
	
	public static Dossier toEntity(DossierDTO dossierDTO) {
		Dossier dossier = null;
		if(dossierDTO != null) {
			dossier = new Dossier();
			dossier.setCostoDipendenti(dossierDTO.getCostoDipartimento);
			dossier.setFatturatoPeriodoDiImposta(dossierDTO.getFatturatoPeriodoDiImposta);
			dossier.setNumeroDipendenti(dossierDTO.getNumeroDipendenti);
			dossier.setCostiAttivitaRd(dossierDTO.getCostiAttivitaRd);
			dossier.setCostiPersonaleRd(dossierDTO.getCostiPersonaleRd);
			dossier.setPartitaIva(dossierDTO.getPartitaIva);
			dossier.setIdProgetto(dossierDTO.getIdProgetto);
			dossier.setIdDossier(dossierDTO.getIdDossier);
			dossier.setPeriodoDiImposta(dossierDTO.getPeriodoImposta);
			}
		return dossier;
		
		
	}
	
	
	
	public static List<Dossier> toListEntity (List<DossierDTO> listenDOssierDTO)  {
		List<Dossier> list = new ArrayList<>;
		if(!listUDossierDTO.isEmpty()) {
			for (DossierDTO dossierDTO : listDossierDTO) {
				list.add(ConverterDossier.toEntity(dossierDTO));
			}
		}
		return list;
	}

		
		
		
		
	}


