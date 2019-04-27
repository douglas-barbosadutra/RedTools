import { Component, OnInit } from '@angular/core';
import { AziendaClienteService } from '../../../services/aziendaCliente.service';
import { AziendaCliente } from '../../../models/AziendaCliente';
import { Router } from '@angular/router';

@Component({
    selector: 'app-fattura-management',
    templateUrl: './fattura-management.component.html',
    styleUrls: ['./fattura-management.component.css']
})
export class FatturaManagementComponent implements OnInit {
    public aziendaClienteList: Array<AziendaCliente>;
    public idBo: number;
    public campi = 12;


    constructor(private aziendaClienteService: AziendaClienteService, private router: Router) { }

    ngOnInit() {
        this.aziendaClienteService.aziendaClienteList().subscribe((response) => {
            this.aziendaClienteList = response;
            console.log('La grandezza e\'' + this.aziendaClienteList.length);
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