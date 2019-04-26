import { Dossier } from './Dossier';
import { Impiegato } from './Impiegato';

export class PercentualeOreReD {
    idPercentualeOreReD: number;
    percentualeOreLavorateReD: number;
    dossier: Dossier;
    impiegato: Impiegato;

    // tslint:disable-next-line:max-line-length
    constructor(idPercentualeOreReD: number, percentualeOreLavorateReD: number, dossier: Dossier, impiegato: Impiegato) {
        this.idPercentualeOreReD = idPercentualeOreReD;
        this.percentualeOreLavorateReD = percentualeOreLavorateReD;
        this.dossier = dossier;
        this.impiegato = impiegato;
    }
}
