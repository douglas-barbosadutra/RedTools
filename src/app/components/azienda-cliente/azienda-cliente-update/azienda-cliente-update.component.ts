import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../../../services/user.service';
import { User } from '../../../models/User';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-user-update',
  templateUrl: './azienda-cliente-update.component.html',
  styleUrls: ['./azienda-cliente-update.component.css']
})
export class AziendaClienteUpdateComponent implements OnInit {

    idUser: number;
    public updateUser: User;

    public userTypes = [];

    // tslint:disable-next-line:max-line-length
    constructor(private userService: UserService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
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
