import { Injectable } from '@angular/core';
import { environment } from '../models/environment.models';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/User';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { logging } from 'protractor';

@Injectable({
    providedIn: 'root'
})
export class UserService {
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
            if (sessionStorage.getItem('user') != null) {
                return true;
            }
            // tslint:disable-next-line:align
        } return false;
    }

    userList(): Observable<Array<User>> {
        return this.http.get<any>('http://localhost:8080/UserController/userManagement')
            .pipe(tap((response) => console.log('User'), catchError(this.handleError('error', {})))
            );
    }


    readUser(userId: number): Observable<User> {
        return this.http.get<any>('http://localhost:8080/UserController/read?userId=' + userId)
            .pipe(tap((response) => console.log('User'), catchError(this.handleError('error', {})))
            );
    }


    updateUser(user: User): void {
        this.http.put('http://localhost:8080/UserController/update', user).subscribe(() => console.log('User updated'));
    }



    deleteUser(userId: number) {
        this.http.delete('http://localhost:8080/UserController/delete?userId=' + userId).subscribe(() => console.log('User deleted'));
    }

    insertUser(user: User): void {
        this.http.post('http://localhost:8080/UserController/insert', user).subscribe(() => console.log('User inserted'));
    }

    clientList(user: User): Observable<Array<User>> {
        return this.http.post<Array<User>>('http://localhost:8080/UserController/clientList', user).pipe(tap((response) =>
        console.log('Clienti'), catchError(this.handleError('error', {}))));
    }
}


