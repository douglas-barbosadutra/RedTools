import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PercentualeOreReDService } from '../../../services/percentualeOreReD.service';
import { Router } from '@angular/router';
import { PercentualeOreReD } from '../../../models/PercentualeOreReD';
import { Dossier } from '../../../models/Dossier';
import { Impiegato } from 'src/app/models/Impiegato';

@Component({
    selector: 'app-percentuale-ore-red-insert',
    templateUrl: './percentuale-ore-red-insert.component.html',
    styleUrls: ['./percentuale-ore-red-insert.component.css']
})
export class PercentualeOreReDInsertComponent implements OnInit {
    public insertPercentualeOreReD: PercentualeOreReD;

    public percentualeOreReDTypes = [];
    constructor(private percentualeOreReDService: PercentualeOreReDService, private router: Router) { }

    ngOnInit() {
        this.insertPercentualeOreReD = new PercentualeOreReD(0, 0, null, null);
    }
    percentualeOreReDInsert(f: NgForm) {
        const dossier: Dossier = JSON.parse(sessionStorage.getItem('dossier'));
        this.insertPercentualeOreReD.dossier = dossier;
        const impiegato: Impiegato = JSON.parse(sessionStorage.getItem('impiegato'));
        this.insertPercentualeOreReD.impiegato = impiegato;
        this.percentualeOreReDService.insertPercentualeOreReD(this.insertPercentualeOreReD);
    }

}
