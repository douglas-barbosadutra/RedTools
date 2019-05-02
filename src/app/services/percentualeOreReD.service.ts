import { Injectable } from '@angular/core';
import { environment } from '../models/environment.models';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { PercentualeOreReD } from '../models/PercentualeOreReD';
import { Impiegato } from '../models/Impiegato';
import { Dossier } from '../models/Dossier';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { logging } from 'protractor';

@Injectable({
    providedIn: 'root'
})
export class PercentualeOreReDService {
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
            if (sessionStorage.getItem('percentualeOreReD') != null) {
                return true;
            }
            // tslint:disable-next-line:align
        } return false;
    }

    percentualeOreReDList(): Observable<Array<PercentualeOreReD>> {
        const impiegato: Impiegato = JSON.parse(sessionStorage.getItem('impiegato'));
        const dossier: Dossier = JSON.parse(sessionStorage.getItem('dossier'));
        return this.http.get<any>('http://localhost:8080/PercentualeOreReDController/percentualeOreReDManagement?impiegatoId=' + impiegato.idNome + '&dossierId=' + dossier.idDossier)
            .pipe(tap((response) => console.log('PercentualeOreReD'), catchError(this.handleError('error', {})))
            );
    }


    readPercentualeOreReD(percentualeOreReDId: number): Observable<PercentualeOreReD> {
        return this.http.get<any>('http://localhost:8080/PercentualeOreReDController/read?percentualeOreReDId=' + percentualeOreReDId)
            .pipe(tap((response) => console.log('PercentualeOreReD'), catchError(this.handleError('error', {})))
            );
    }


    updatePercentualeOreReD(percentualeOreReD: PercentualeOreReD): void {
        this.http.put('http://localhost:8080/PercentualeOreReDController/update', percentualeOreReD).subscribe(() => console.log('PercentualeOreReD updated'));
    }



    deletePercentualeOreReD(percentualeOreReDId: number) {
        this.http.delete('http://localhost:8080/PercentualeOreReDController/delete?percentualeOreReDId=' + percentualeOreReDId).subscribe(() => console.log('PercentualeOreReD deleted'));
    }

    insertPercentualeOreReD(percentualeOreReD: PercentualeOreReD): void {
        this.http.post('http://localhost:8080/PercentualeOreReDController/insert', percentualeOreReD).subscribe(() => console.log('PercentualeOreReD inserted'));
    }


}



