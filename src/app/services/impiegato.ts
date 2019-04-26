import { Injectable } from '@angular/core';
import { environment } from '../models/environment.models';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Impiegato } from '../models/Impiegato';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { logging } from 'protractor';

@Injectable({
    providedIn: 'root'
})
export class ImpiegatoService {
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
            if (sessionStorage.getItem('impiegato') != null) {
                return true;
            }
            // tslint:disable-next-line:align
        } return false;
    }

    impiegatoList(idAziendaCliente: number): Observable<Array<Impiegato>> {
        return this.http.get<any>('http://localhost:8080/ImpiegatoController/impiegatoManagement?idAziendaCliente=' + idAziendaCliente)
            .pipe(tap((response) => console.log('Impiegato'), catchError(this.handleError('error', {})))
            );
    }


    readImpiegato(idImpiegato: number): Observable<Impiegato> {
        return this.http.get<any>('http://localhost:8080/ImpiegatoController/read?idImpiegato=' + idImpiegato)
            .pipe(tap((response) => console.log('Impiegato'), catchError(this.handleError('error', {})))
            );
    }


    updateImpiegato(impiegato: Impiegato): void {
        this.http.put('http://localhost:8080/ImpiegatoController/update', impiegato).subscribe(() => console.log('Impiegato updated'));
    }



    deleteImpiegato(idImpiegato: number) {
        this.http.delete('http://localhost:8080/ImpiegatoController/delete?idImpiegato=' + idImpiegato).subscribe(() => console.log('Impiegato deleted'));
    }

    insertImpiegato(impiegato: Impiegato): void {
        this.http.post('http://localhost:8080/ImpiegatoController/insert', impiegato).subscribe(() => console.log('Impiegato inserted'));
    }


}



