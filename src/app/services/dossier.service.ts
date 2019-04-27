import { Injectable } from '@angular/core';
import { environment } from '../models/environment.models';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Dossier } from '../models/Dossier';
import { Progetto } from '../models/Progetto';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { logging } from 'protractor';

@Injectable({
    providedIn: 'root'
})
export class DossierService {
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
            if (sessionStorage.getItem('dossier') != null) {
                return true;
            }
            // tslint:disable-next-line:align
        } return false;
    }

    dossierList(): Observable<Array<Dossier>> {
        const progetto: Progetto = JSON.parse(sessionStorage.getItem('progetto'));
        return this.http.get<any>('http://localhost:8080/DossierController/dossierManagement?progettoId=' + progetto.idProgetto)
            .pipe(tap((response) => console.log('Dossier'), catchError(this.handleError('error', {})))
            );
    }


    readDossier(id: number): Observable<Dossier> {
        return this.http.get<any>('http://localhost:8080/DossierController/read?id=' + id)
            .pipe(tap((response) => console.log('Dossier'), catchError(this.handleError('error', {})))
            );
    }


    updateDossier(dossier: Dossier): void {
        this.http.put('http://localhost:8080/DossierController/update', dossier).subscribe(() => console.log('Dossier updated'));
    }



    deleteDossier(id: number) {
        this.http.delete('http://localhost:8080/DossierController/delete?id=' + id).subscribe(() => console.log('Dossier deleted'));
    }

    insertDossier(dossier: Dossier): void {
        this.http.post('http://localhost:8080/DossierController/insert', dossier).subscribe(() => console.log('Dossier inserted'));
    }


}



