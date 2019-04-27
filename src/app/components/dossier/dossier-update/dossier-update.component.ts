import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AziendaClienteService } from '../../../services/aziendaCliente.service';
import { AziendaCliente } from '../../../models/AziendaCliente';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-dossier-update',
  templateUrl: './dossier-update.component.html',
  styleUrls: ['./dossier-update.component.css']
})
export class DossierUpdateComponent implements OnInit {

    idAziendaCliente: number;
    public updateAziendaCliente: AziendaCliente;

    public aziendaClienteTypes = [];

    // tslint:disable-next-line:max-line-length
    constructor(private aziendaClienteService: AziendaClienteService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        /** Convert String to number */
        this.idAziendaCliente = Number(this.route.snapshot.paramMap.get('idAziendaCliente'));
        console.log('AziendaCliente id in update:' + this.idAziendaCliente);
        this.aziendaClienteService.readAziendaCliente(this.idAziendaCliente).subscribe((response) => {
            this.updateAziendaCliente = response;
            console.log('AziendaCliente caricato: ' + this.updateAziendaCliente.denominazioneSocieta);
        });
    }

    update(f: NgForm) {
        console.log('AziendaCliente id: ' + f.value.idAziendaCliente + ' ' + f.value.denominazioneSocieta);
        this.aziendaClienteService.updateAziendaCliente(this.updateAziendaCliente);

    }
}
