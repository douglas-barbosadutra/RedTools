import { User } from './User';

export class AziendaCliente {
    idAziendaCliente: number;
    denominazioneSocieta: string;
    formaGiuridica: string;
    sedeLegale: string;
    partitaIva: string;
    telefono: string;
    email: string;
    indirizzoUnitaLocale: string;
    attivitaAzienda: string;
    legaleRappresentante: string;
    natoA: string;
    natoIl: string;
    filledFields: number;
    user: User;

    // tslint:disable-next-line:max-line-length
    constructor(idAziendaCliente: number, denominazioneSocieta: string, formaGiuridica: string, sedeLegale: string,
                partitaIva: string, telefono: string, email: string, indirizzoUnitaLocale: string, attivitaAzienda: string,
                legaleRappresentante: string, natoA: string, natoIl: string, filledFields: number, user: User) {
        this.idAziendaCliente = idAziendaCliente;
        this.denominazioneSocieta = denominazioneSocieta;
        this.formaGiuridica = formaGiuridica;
        this.sedeLegale = sedeLegale;
        this.partitaIva = partitaIva;
        this.telefono = telefono;
        this.email = email;
        this.indirizzoUnitaLocale = indirizzoUnitaLocale;
        this.attivitaAzienda = attivitaAzienda;
        this.legaleRappresentante = legaleRappresentante;
        this.natoA = natoA;
        this.natoIl = natoIl;
        this.filledFields = filledFields;
        this.user = user;
    }
}
