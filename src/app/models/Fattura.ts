import { Dossier } from './Dossier';
import { Fornitore } from './Fornitore';

export class Fattura {
    idFattura: number;
    dataFattura: string;
    numeroFattura: string;
    descrizione: string;
    totaleImponibile: number;
    percentualeAmmissibile: number;
    dossier: Dossier;
    fornitore: Fornitore;

    // tslint:disable-next-line:max-line-length
    constructor(idFattura: number, dataFattura: string, numeroFattura: string, descrizione: string, totaleImponibile: number,
                percentualeAmmissibile: number, dossier: Dossier, fornitore: Fornitore) {
        this.idFattura = idFattura;
        this.dataFattura = dataFattura;
        this.numeroFattura = numeroFattura;
        this.descrizione = descrizione;
        this.totaleImponibile = totaleImponibile;
        this.percentualeAmmissibile = percentualeAmmissibile;
        this.dossier = dossier;
        this.fornitore = fornitore;
    }
}
