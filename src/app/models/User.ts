export class User {
    idUser: number;
    username: string;
    password: string;
    ruolo: string;
    email: string;
    bo: User;

    // tslint:disable-next-line:max-line-length
    constructor(idUser: number, username: string, password: string, ruolo: string, email: string, bo: User) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.ruolo = ruolo;
        this.email = email;
        this.bo = bo;
    }
}