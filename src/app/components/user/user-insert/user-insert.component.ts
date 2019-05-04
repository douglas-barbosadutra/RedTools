import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../../../services/user.service';
import { Router } from '@angular/router';
import { User } from '../../../models/User';
import { AziendaCliente } from 'src/app/models/AziendaCliente';


@Component({
    selector: 'app-user-insert',
    templateUrl: './user-insert.component.html',
    styleUrls: ['./user-insert.component.css']
})
export class UserInsertComponent implements OnInit {
    public insertUser: User;
    public aziendaCliente: AziendaCliente
    public user: User;

    public userTypes = [];
    constructor(private userService: UserService, private router: Router) { }

    ngOnInit() {
        this.aziendaCliente = JSON.parse(sessionStorage.getItem('aziendaCliente'));
        this.user = JSON.parse(sessionStorage.getItem('user'));
        if (this.aziendaCliente == null && this.user.ruolo != 'user') {
            this.insertUser = new User(0, null, null, 'superuser', null, null);
            this.userTypes = ['superuser', 'user'];
        } else if (this.aziendaCliente != null) {
            this.insertUser = new User(0, null, null, 'cliente', null, this.aziendaCliente.user);
            this.userTypes = ['cliente'];
        } else if (this.user.ruolo == 'user') {
            this.insertUser = new User(0, null, null, 'cliente', null, this.user);
            this.userTypes = ['cliente'];
        }
        
    }
    userInsert(f: NgForm) {
        this.userService.insertUser(this.insertUser);
    }

}