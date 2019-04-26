import { Injectable } from '@angular/core';
import { environment } from '../models/environment.models';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Fattura } from '../models/Fattura';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { logging } from 'protractor';

@Injectable({
    providedIn: 'root'
})
export class FatturaService {
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
            if (sessionStorage.getItem('fattura') != null) {
                return true;
            }
            // tslint:disable-next-line:align
        } return false;
    }

    fatturaList(fornitoreId: number, dossierId: number): Observable<Array<Fattura>> {
        return this.http.get<any>('http://localhost:8080/FatturaController/fatturaManagement?fornitoreId=' + fornitoreId + '&dossierId=' + dossierId)
            .pipe(tap((response) => console.log('Fattura'), catchError(this.handleError('error', {})))
            );
    }


    readFattura(idFattura: number): Observable<Fattura> {
        return this.http.get<any>('http://localhost:8080/FatturaController/read?idFattura=' + idFattura)
            .pipe(tap((response) => console.log('Fattura'), catchError(this.handleError('error', {})))
            );
    }


    updateFattura(fattura: Fattura): void {
        this.http.put('http://localhost:8080/FatturaController/update', fattura).subscribe(() => console.log('Fattura updated'));
    }



    deleteFattura(idFattura: number) {
        this.http.delete('http://localhost:8080/FatturaController/delete?idFattura=' + idFattura).subscribe(() => console.log('Fattura deleted'));
    }

    insertFattura(fattura: Fattura): void {
        this.http.post('http://localhost:8080/FatturaController/insert', fattura).subscribe(() => console.log('Fattura inserted'));
    }


}



