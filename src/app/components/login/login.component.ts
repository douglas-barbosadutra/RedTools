import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
/** import { UserService } from '../../services/user.service'; */
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { LoginService } from '../../services/login.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    user: User;

    constructor(private loginService: LoginService, private router: Router) {

    }
    ngOnInit() {
        console.log('arrivato');
    }

    login(f: NgForm): void {
        console.log('mi arrivano username=' + f.value.username + ' password= ' + f.value.password);
        this.loginService.login(f.value.username, f.value.password).subscribe((response) => {
            console.log('Risposta ricevuta');
            if (response != null) {
                this.user = response;
                sessionStorage.setItem('user', JSON.stringify(this.user));
                console.log('Username: ' + this.user.username);
                if (response.ruolo === 'superuser') {
                    this.router.navigateByUrl('/User/userManagement');
                } else if (response.ruolo === 'user') {
                    this.router.navigateByUrl('/AziendaCliente/aziendaClienteManagement');
                }
            }
        });
    }

}