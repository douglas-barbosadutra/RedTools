import { Component, OnInit } from '@angular/core';
import { AziendaClienteService } from '../../../services/aziendaCliente.service';
import { AziendaCliente } from '../../../models/AziendaCliente';
import { Router } from '@angular/router';

@Component({
    selector: 'app-aziendaCliente-management',
    templateUrl: './azienda-cliente-management.component.html',
    styleUrls: ['./azienda-cliente-management.component.css']
})
export class AziendaClienteManagementComponent implements OnInit {
    public aziendaClientes: Array<AziendaCliente>;
    idBo: number;

    constructor(private aziendaClienteService: AziendaClienteService, private router: Router) { }

    ngOnInit() {
        this.aziendaClienteService.aziendaClienteList().subscribe((response) => {
            this.aziendaClientes = response;
            console.log('La grandezza e\'' + this.aziendaClientes.length);
        });
    }

    removeLink(aziendaClienteId: number) {
        this.aziendaClienteService.deleteAziendaCliente(aziendaClienteId);

    }

    updateLink(aziendaClienteId: number) {
        this.router.navigateByUrl('/AziendaCliente/update/' + aziendaClienteId);
    }

    insertLink() {
        this.router.navigateByUrl('/AziendaCliente/insert');
    }

}