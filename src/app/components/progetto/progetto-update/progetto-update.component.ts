import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProgettoService } from '../../../services/progetto.service';
import { Progetto } from '../../../models/Progetto';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-progetto-update',
  templateUrl: './progetto-update.component.html',
  styleUrls: ['./progetto-update.component.css']
})
export class ProgettoUpdateComponent implements OnInit {

    idProgetto: number;
    public updateProgetto: Progetto;

    public progettoTypes = [];

    // tslint:disable-next-line:max-line-length
    constructor(private progettoService: ProgettoService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        /** Convert String to number */
        this.idProgetto = Number(this.route.snapshot.paramMap.get('idProgetto'));
        console.log('progetto id in update:' + this.idProgetto);
        this.progettoService.readProgetto(this.idProgetto).subscribe((response) => {
            this.updateProgetto = response;
            console.log('Progetto caricato: ' + this.updateProgetto.titoloProgetto);
        });
    }

    update(f: NgForm) {
        console.log('Progetto id: ' + f.value.idProgetto + ' ' + f.value.denominazioneSocieta);
        this.progettoService.updateProgetto(this.updateProgetto);

    }
}
