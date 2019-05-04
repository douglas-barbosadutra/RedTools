import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../services/user.service';
import { User } from '../../../models/User';
import { Router } from '@angular/router';
import { AziendaCliente } from 'src/app/models/AziendaCliente';

@Component({
    selector: 'app-user-management',
    templateUrl: './user-management.component.html',
    styleUrls: ['./user-management.component.css']
})
export class UserManagementComponent implements OnInit {
    public users: Array<User>;
    public aziendaCliente: AziendaCliente;

    constructor(private userService: UserService, private router: Router) { }

    ngOnInit() {
        this.aziendaCliente = JSON.parse(sessionStorage.getItem('aziendaCliente'));
        if (this.aziendaCliente == null) {
            this.userService.userList().subscribe((response) => {
                this.users = response;
                console.log('La grandezza e\'' + this.users.length);
            });
        } else {
            this.userService.clientList(this.aziendaCliente.user).subscribe((response) => {
                this.users = response;
                console.log('La grandezza e\'' + this.users.length);
            });
        }
    }

    removeLink(userId: number) {
        this.userService.deleteUser(userId);

    }

    updateLink(userId: number) {
        this.router.navigateByUrl('/User/update/' + userId);
    }

    insertLink() {
        this.router.navigateByUrl('/User/insert');
    }

}