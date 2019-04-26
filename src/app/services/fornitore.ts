import { Injectable } from '@angular/core';
import { environment } from '../models/environment.models';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Fornitore } from '../models/Fornitore';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { logging } from 'protractor';

@Injectable({
    providedIn: 'root'
})
export class FornitoreService {
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
            if (sessionStorage.getItem('fornitore') != null) {
                return true;
            }
            // tslint:disable-next-line:align
        } return false;
    }

    fornitoreList(): Observable<Array<Fornitore>> {
        return this.http.get<any>('http://localhost:8080/FornitoreController/fornitoreManagement')
            .pipe(tap((response) => console.log('Fornitore'), catchError(this.handleError('error', {})))
            );
    }


    readFornitore(fornitoreId: number): Observable<Fornitore> {
        return this.http.get<any>('http://localhost:8080/FornitoreController/read?fornitoreId=' + fornitoreId)
            .pipe(tap((response) => console.log('Fornitore'), catchError(this.handleError('error', {})))
            );
    }


    updateFornitore(fornitore: Fornitore): void {
        this.http.put('http://localhost:8080/FornitoreController/update', fornitore).subscribe(() => console.log('Fornitore updated'));
    }



    deleteFornitore(fornitoreId: number) {
        this.http.delete('http://localhost:8080/FornitoreController/delete?fornitoreId=' + fornitoreId).subscribe(() => console.log('Fornitore deleted'));
    }

    insertFornitore(fornitore: Fornitore): void {
        this.http.post('http://localhost:8080/FornitoreController/insert', fornitore).subscribe(() => console.log('Fornitore inserted'));
    }


}



