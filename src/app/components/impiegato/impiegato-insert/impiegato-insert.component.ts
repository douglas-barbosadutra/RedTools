import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ImpiegatoService } from '../../../services/impiegato.service';
import { Router } from '@angular/router';
import { Impiegato } from '../../../models/Impiegato';
import { AziendaCliente } from 'src/app/models/AziendaCliente';

@Component({
    selector: 'app-impiegato-insert',
    templateUrl: './impiegato-insert.component.html',
    styleUrls: ['./impiegato-insert.component.css']
})
export class ImpiegatoInsertComponent implements OnInit {
    public insertImpiegato: Impiegato;

    public impiegatoTypes = [];
    constructor(private impiegatoService: ImpiegatoService, private router: Router) { }

    ngOnInit() {
        this.insertImpiegato = new Impiegato(0, null, 0, null, null, null, 0, 0, null);
    }
    impiegatoInsert(f: NgForm) {
        const aziendaCliente: AziendaCliente = JSON.parse(sessionStorage.getItem('aziendaCliente'));
        this.insertImpiegato.aziendaCliente = aziendaCliente;
        this.impiegatoService.insertImpiegato(this.insertImpiegato);
    }

}
