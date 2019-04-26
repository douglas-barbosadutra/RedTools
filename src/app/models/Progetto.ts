import { AziendaCliente } from './AziendaCliente';

export class Progetto {
    idProgetto: number;
    titoloProgetto: string;
    aziendaClienteDTO: AziendaCliente;
    dettagliProgetto: string;
    coordinateDIIN: string;

    // tslint:disable-next-line:max-line-length
    constructor(idMom: number, titoloProgetto: string, aziendaClienteDTO: AziendaCliente, dettagliProgetto: string,
                coordinateDIIN: string) {
        this.idProgetto = idMom;
        this.titoloProgetto = titoloProgetto;
        this.aziendaClienteDTO = aziendaClienteDTO;
        this.dettagliProgetto = dettagliProgetto;
        this.coordinateDIIN = coordinateDIIN;
    }
}
