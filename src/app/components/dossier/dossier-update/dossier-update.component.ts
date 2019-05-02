import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { DossierService } from '../../../services/dossier.service';
import { Dossier } from '../../../models/Dossier';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-dossier-update',
  templateUrl: './dossier-update.component.html',
  styleUrls: ['./dossier-update.component.css']
})
export class DossierUpdateComponent implements OnInit {

    idDossier: number;
    public updateDossier: Dossier;

    public dossierTypes = [];

    // tslint:disable-next-line:max-line-length
    constructor(private dossierService: DossierService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        /** Convert String to number */
        this.idDossier = Number(this.route.snapshot.paramMap.get('idDossier'));
        console.log('Dossier id in update:' + this.idDossier);
        this.dossierService.readDossier(this.idDossier).subscribe((response) => {
            this.updateDossier = response;
            console.log('Dossier caricato: ' + this.updateDossier.periodoDiImposta);
        });
    }

    update(f: NgForm) {
        console.log('Dossier id: ' + f.value.idDossier + ' ' + f.value.denominazioneSocieta);
        this.dossierService.updateDossier(this.updateDossier);

    }
}
