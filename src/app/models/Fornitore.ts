export class Fornitore {
    idFornitore: number;
    nomeFornitore: string;
    comuneFornitore: string;
    provinciaFornitore: string;
    partitaIvaFornitore: string;

    // tslint:disable-next-line:max-line-length
    constructor(idFornitore: number, nomeFornitore: string, comuneFornitore: string, provinciaFornitore: string,
                partitaIvaFornitore: string) {
        this.idFornitore = idFornitore;
        this.nomeFornitore = nomeFornitore;
        this.comuneFornitore = comuneFornitore;
        this.provinciaFornitore = provinciaFornitore;
        this.partitaIvaFornitore = partitaIvaFornitore;
    }
}
