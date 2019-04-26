import { AziendaCliente } from './AziendaCliente';

export class Mom {
    idMom: number;
    luogoMom: string;
    dataDelGiornoMom: string;
    orarioMom: string;
    oggettoMom: string;
    progettoMom: string;
    partecipantiMom: string;
    testoAgendaMom: string;
    testoAzioneMom: string;
    testoNoteMom: string;
    aziendaCliente: AziendaCliente;

    // tslint:disable-next-line:max-line-length
    constructor(idMom: number, luogoMom: string, dataDelGiornoMom: string, orarioMom: string, oggettoMom: string,
                progettoMom: string, partecipantiMom: string, testoAgendaMom: string, testoAzioneMom: string,
                testoNoteMom: string, aziendaCliente: AziendaCliente) {
        this.idMom = idMom;
        this.luogoMom = luogoMom;
        this.dataDelGiornoMom = dataDelGiornoMom;
        this.orarioMom = orarioMom;
        this.oggettoMom = oggettoMom;
        this.progettoMom = progettoMom;
        this.partecipantiMom = partecipantiMom;
        this.testoAgendaMom = testoAgendaMom;
        this.testoAzioneMom = testoAzioneMom;
        this.testoNoteMom = testoNoteMom;
        this.aziendaCliente = aziendaCliente;
    }
}
