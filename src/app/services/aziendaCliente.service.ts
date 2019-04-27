import { Injectable } from '@angular/core';
import { environment } from '../models/environment.models';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { AziendaCliente } from '../models/AziendaCliente';
import { User } from '../models/User';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { logging } from 'protractor';

@Injectable({
    providedIn: 'root'
})
export class AziendaClienteService {
    private urlBase = environment.url;

    constructor(private http: HttpClient) { }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }

    isLogged(): boolean {
        if (typeof (Storage) !== 'undefined') {
            if (sessionStorage.getItem('aziendaCliente') != null) {
                return true;
            }
            // tslint:disable-next-line:align
        } return false;
    }

    aziendaClienteList(): Observable<Array<AziendaCliente>> {
        const user: User = JSON.parse(sessionStorage.getItem('user'));
        return this.http.get<any>('http://localhost:8080/AziendaClienteController/aziendaClienteManagement?idBo=' + user.idUser)
            .pipe(tap((response) => console.log('AziendaCliente'), catchError(this.handleError('error', {})))
            );
    }


    readAziendaCliente(id: number): Observable<AziendaCliente> {
        return this.http.get<any>('http://localhost:8080/AziendaClienteController/read?id=' + id)
            .pipe(tap((response) => console.log('AziendaCliente'), catchError(this.handleError('error', {})))
            );
    }


    updateAziendaCliente(aziendaCliente: AziendaCliente): void {
        this.http.put('http://localhost:8080/AziendaClienteController/update', aziendaCliente).subscribe(() => console.log('AziendaCliente updated'));
    }



    deleteAziendaCliente(id: number) {
        this.http.delete('http://localhost:8080/AziendaClienteController/delete?id=' + id).subscribe(() => console.log('AziendaCliente deleted'));
    }

    insertAziendaCliente(aziendaCliente: AziendaCliente): void {
        this.http.post('http://localhost:8080/AziendaClienteController/insert', aziendaCliente).subscribe(() => console.log('AziendaCliente inserted'));
    }


}



