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
				dossier.setFatturatoPeriodoDiImposta(dossierDTO.getFatturatoPeriodoDiImposta());
				dossier.setNumeroTotaleDipendenti(dossierDTO.getNumeroTotaleDipendenti());
				dossier.setFilledFields(dossierDTO.getFilledFields());
				Progetto progetto = dossierDTO.getProgetto();
				dossier.setProgetto(progetto);
				dossier.setAziendaCliente(dossierDTO.getAziendacliente());
				
				
			}
	
			return dossier;

}
		
		
			public static DossierDTO toDTO(Dossier dossier) {

				DossierDTO dossierDTO = null;
				if (dossier != null) {
					dossierDTO= new DossierDTO();
					dossierDTO.setIdDossier(dossierDTO.getIdDossier());
					dossierDTO.setPeriodoDiImposta(dossierDTO.getPeriodoDiImposta());
					dossierDTO.setFatturatoPeriodoDiImposta(dossierDTO.getFatturatoPeriodoDiImposta());
					dossierDTO.setNumeroTotaleDipendenti(dossierDTO.getNumeroTotaleDipendenti());
					dossierDTO.setFilledFields(dossierDTO.getFilledFields());
					dossierDTO.setProgetto(dossier.getProgetto());
					dossierDTO.setAziendaCliente(dossier.getAziendaCliente());
					
					
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
			
			
}