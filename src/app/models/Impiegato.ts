import { AziendaCliente } from './AziendaCliente';

export class Impiegato {
    idNome: number;
    nominativo: string;
    livello: number;
    qualifica: string;
    mansione: string;
    titoloDiStudio: string;
    totaleOreLavorate: number;
    costoLordoAnnuo: number;
    aziendaCliente: AziendaCliente;

    // tslint:disable-next-line:max-line-length
    constructor(idNome: number, nominativo: string, livello: number, qualifica: string, mansione: string,
                titoloDiStudio: string, totaleOreLavorate: number, costoLordoAnnuo: number, aziendaCliente: AziendaCliente) {
        this.idNome = idNome;
        this.nominativo = nominativo;
        this.livello = livello;
        this.qualifica = qualifica;
        this.mansione = mansione;
        this.titoloDiStudio = titoloDiStudio;
        this.totaleOreLavorate = totaleOreLavorate;
        this.costoLordoAnnuo = costoLordoAnnuo;
        this.aziendaCliente = aziendaCliente;
    }
}
