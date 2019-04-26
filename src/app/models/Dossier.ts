import { Progetto } from './Progetto';

export class Dossier {
    idDossier: number;
    periodoDiImposta: string;
    costoDipendentiPeriodoDiImposta: number;
    fatturatoPeriodoDiImposta: number;
    numeroTotaleDipendenti: number;
    totaleCostiReD: number;
    costiPersonaleReD: number;
    filledFields: number;
    progettoDTO: Progetto;

    // tslint:disable-next-line:max-line-length
    constructor(idDossier: number, periodoDiImposta: string, costoDipendentiPeriodoDiImposta: number, fatturatoPeriodoDiImposta: number, numeroTotaleDipendenti: number,
                totaleCostiReD: number, costiPersonaleReD: number, filledFields: number, progettoDTO: Progetto) {
        this.idDossier = idDossier;
        this.periodoDiImposta = periodoDiImposta;
        this.costoDipendentiPeriodoDiImposta = costoDipendentiPeriodoDiImposta;
        this.fatturatoPeriodoDiImposta = fatturatoPeriodoDiImposta;
        this.numeroTotaleDipendenti = numeroTotaleDipendenti;
        this.totaleCostiReD = totaleCostiReD;
        this.costiPersonaleReD = costiPersonaleReD;
        this.filledFields = filledFields;
        this.progettoDTO = progettoDTO;
    }
}
