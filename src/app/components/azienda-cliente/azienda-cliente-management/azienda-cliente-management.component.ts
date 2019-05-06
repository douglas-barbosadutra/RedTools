import { Component, OnInit } from '@angular/core';
import { AziendaClienteService } from '../../../services/aziendaCliente.service';
import { AziendaCliente } from '../../../models/AziendaCliente';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';

@Component({
    selector: 'app-azienda-cliente-management',
    templateUrl: './azienda-cliente-management.component.html',
    styleUrls: ['./azienda-cliente-management.component.css']
})
export class AziendaClienteManagementComponent implements OnInit {
    public aziendaClienteList: Array<AziendaCliente>;
    public idBo: number;
    public campi = 12;
    public user: User;


    constructor(private aziendaClienteService: AziendaClienteService, private router: Router) { }

    ngOnInit() {
        this.user = JSON.parse(sessionStorage.getItem('user'));
        if (this.user.ruolo != 'cliente') {
            this.aziendaClienteService.aziendaClienteList().subscribe((response) => {
                this.aziendaClienteList = response;
                console.log('La grandezza e\'' + this.aziendaClienteList.length);
            });
        } else {
            this.aziendaClienteService.aziendaCliente(this.user).subscribe((response) => {
                this.aziendaClienteList = response;
                console.log('La grandezza e\'' + this.aziendaClienteList.length);
            });
        }
    }

    removeLink(aziendaClienteId: number) {
        this.aziendaClienteService.deleteAziendaCliente(aziendaClienteId);

    }

    updateLink(aziendaClienteId: number) {
        this.router.navigateByUrl('/AziendaCliente/update/' + aziendaClienteId);
    }

    insertLink() {
        this.router.navigateByUrl('/User/insert');
    }

    momLink(aziendaCliente: AziendaCliente) {
        sessionStorage.setItem('aziendaCliente', JSON.stringify(aziendaCliente));
        this.router.navigateByUrl('/Mom/momManagement');
    }

    progettoLink(aziendaCliente: AziendaCliente) {
        sessionStorage.setItem('aziendaCliente', JSON.stringify(aziendaCliente));
        this.router.navigateByUrl('/Progetto/progettoManagement');
    }

   userLink(aziendaCliente: AziendaCliente) {
        sessionStorage.setItem('aziendaCliente', JSON.stringify(aziendaCliente));
        this.router.navigateByUrl('/User/userManagement');
    }
}
