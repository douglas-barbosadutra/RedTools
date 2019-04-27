import { Injectable } from '@angular/core';
import { environment } from '../models/environment.models';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Mom } from '../models/Mom';
import { AziendaCliente } from '../models/AziendaCliente';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { logging } from 'protractor';

@Injectable({
    providedIn: 'root'
})
export class MomService {
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
            if (sessionStorage.getItem('mom') != null) {
                return true;
            }
            // tslint:disable-next-line:align
        } return false;
    }

    momList(): Observable<Array<Mom>> {
        const aziendaCliente: AziendaCliente = JSON.parse(sessionStorage.getItem('aziendaCliente'));
        return this.http.get<any>('http://localhost:8080/MomController/momManagement?idAziendaCliente=' + aziendaCliente.idAziendaCliente)
            .pipe(tap((response) => console.log('Mom'), catchError(this.handleError('error', {})))
            );
    }


    readMom(idMom: number): Observable<Mom> {
        return this.http.get<any>('http://localhost:8080/MomController/read?idMom=' + idMom)
            .pipe(tap((response) => console.log('Mom'), catchError(this.handleError('error', {})))
            );
    }


    updateMom(mom: Mom): void {
        this.http.put('http://localhost:8080/MomController/update', mom).subscribe(() => console.log('Mom updated'));
    }



    deleteMom(idMom: number) {
        this.http.delete('http://localhost:8080/MomController/delete?idMom=' + idMom).subscribe(() => console.log('Mom deleted'));
    }

    insertMom(mom: Mom): void {
        this.http.post('http://localhost:8080/MomController/insert', mom).subscribe(() => console.log('Mom inserted'));
    }


}



