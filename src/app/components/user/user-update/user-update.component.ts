import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../../../services/user.service';
import { User } from '../../../models/User';
import { NgForm } from '@angular/forms';
import { AziendaCliente } from 'src/app/models/AziendaCliente';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent implements OnInit {

    idUser: number;
    public updateUser: User;
    public aziendaCliente: AziendaCliente;

    public userTypes = [];

    // tslint:disable-next-line:max-line-length
    constructor(private userService: UserService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        this.aziendaCliente = JSON.parse(sessionStorage.getItem('aziendaCliente'));
        /** Convert String to number */
        this.idUser = Number(this.route.snapshot.paramMap.get('idUser'));
        console.log('User id in update:' + this.idUser);
        this.userService.readUser(this.idUser).subscribe((response) => {
            this.updateUser = response;
            console.log('User caricarito: ' + this.updateUser.username);
        });

        this.userTypes = ['superuser', 'user'];
    }

    update(f: NgForm) {
        console.log('User id: ' + f.value.idUser + ' ' + f.value.username);
        this.userService.updateUser(this.updateUser);

    }
}
