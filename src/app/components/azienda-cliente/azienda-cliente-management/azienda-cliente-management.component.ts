import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../services/user.service';
import { User } from '../../../models/User';
import { Router } from '@angular/router';

@Component({
    selector: 'app-user-management',
    templateUrl: './azienda-cliente-management.component.html',
    styleUrls: ['./azienda-cliente-management.component.css']
})
export class AziendaClienteManagementComponent implements OnInit {
    public users: Array<User>;

    constructor(private userService: UserService, private router: Router) { }

    ngOnInit() {
        this.userService.userList().subscribe((response) => {
            this.users = response;
            console.log('La grandezza e\'' + this.users.length);
        });
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