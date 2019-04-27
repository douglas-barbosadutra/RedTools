import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AziendaClienteService } from '../../../services/aziendaCliente.service';
import { Router } from '@angular/router';
import { AziendaCliente } from '../../../models/AziendaCliente';

@Component({
    selector: 'app-aziendaCliente-insert',
    templateUrl: './azienda-cliente-insert.component.html',
    styleUrls: ['./azienda-cliente-insert.component.css']
})
export class AziendaClienteInsertComponent implements OnInit {
    public insertAziendaCliente: AziendaCliente;

    public aziendaClienteTypes = [];
    constructor(private aziendaClienteService: AziendaClienteService, private router: Router) { }

    ngOnInit() {
        this.insertAziendaCliente = new AziendaCliente(0, null, null, null, null, null, null, null, null, null,
            null, null, 0, null);
    }
    aziendaClienteInsert(f: NgForm) {
        this.aziendaClienteService.insertAziendaCliente(this.insertAziendaCliente);
    }

}