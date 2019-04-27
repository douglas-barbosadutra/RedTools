import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AziendaClienteService } from '../../../services/aziendaCliente.service';
import { Router } from '@angular/router';
import { AziendaCliente } from '../../../models/AziendaCliente';
import { User } from '../../../models/User';

@Component({
    selector: 'app-fornitore-insert',
    templateUrl: './fornitore-insert.component.html',
    styleUrls: ['./fornitore-insert.component.css']
})
export class FornitoreInsertComponent implements OnInit {
    public insertAziendaCliente: AziendaCliente;

    public aziendaClienteTypes = [];
    constructor(private aziendaClienteService: AziendaClienteService, private router: Router) { }

    ngOnInit() {
        this.insertAziendaCliente = new AziendaCliente(0, null, null, null, null, null, null, null, null, null,
            null, null, 0, null);
    }
    aziendaClienteInsert(f: NgForm) {
        const user: User = JSON.parse(sessionStorage.getItem('user'));
        this.insertAziendaCliente.user = user;
        this.aziendaClienteService.insertAziendaCliente(this.insertAziendaCliente);
    }

}