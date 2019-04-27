import { Injectable } from '@angular/core';
import { environment } from '../models/environment.models';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Progetto } from '../models/Progetto';
import { AziendaCliente } from '../models/AziendaCliente';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { logging } from 'protractor';

@Injectable({
    providedIn: 'root'
})
export class ProgettoService {
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
            if (sessionStorage.getItem('progetto') != null) {
                return true;
            }
            // tslint:disable-next-line:align
        } return false;
    }

    progettoList(): Observable<Array<Progetto>> {
        const aziendaCliente: AziendaCliente = JSON.parse(sessionStorage.getItem('aziendaCliente'));
        return this.http.get<any>('http://localhost:8080/ProgettoController/progettoManagement?idAziendaCliente=' + aziendaCliente.idAziendaCliente)
            .pipe(tap((response) => console.log('Progetto'), catchError(this.handleError('error', {})))
            );
    }


    readProgetto(idProgetto: number): Observable<Progetto> {
        return this.http.get<any>('http://localhost:8080/ProgettoController/read?idProgetto=' + idProgetto)
            .pipe(tap((response) => console.log('Progetto'), catchError(this.handleError('error', {})))
            );
    }


    updateProgetto(progetto: Progetto): void {
        this.http.put('http://localhost:8080/ProgettoController/update', progetto).subscribe(() => console.log('Progetto updated'));
    }



    deleteProgetto(idProgetto: number) {
        this.http.delete('http://localhost:8080/ProgettoController/delete?idProgetto=' + idProgetto).subscribe(() => console.log('Progetto deleted'));
    }

    insertProgetto(progetto: Progetto): void {
        this.http.post('http://localhost:8080/ProgettoController/insert', progetto).subscribe(() => console.log('Progetto inserted'));
    }


}



