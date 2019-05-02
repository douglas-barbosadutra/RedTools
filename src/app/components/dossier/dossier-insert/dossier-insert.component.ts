import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DossierService } from '../../../services/dossier.service';
import { Router } from '@angular/router';
import { Dossier } from '../../../models/Dossier';
import { Progetto } from 'src/app/models/Progetto';

@Component({
    selector: 'app-dossier-insert',
    templateUrl: './dossier-insert.component.html',
    styleUrls: ['./dossier-insert.component.css']
})
export class DossierInsertComponent implements OnInit {
    public insertDossier: Dossier;

    public dossierTypes = [];
    constructor(private dossierService: DossierService, private router: Router) { }

    ngOnInit() {
        this.insertDossier = new Dossier(0, null, 0, 0, 0, 0, 0, 0, null);
    }
    dossierInsert(f: NgForm) {
        const progetto: Progetto = JSON.parse(sessionStorage.getItem('user'));
        this.insertDossier.progettoDTO = progetto;
        this.dossierService.insertDossier(this.insertDossier);
    }

}