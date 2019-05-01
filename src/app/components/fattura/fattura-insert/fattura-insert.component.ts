import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { FatturaService } from '../../../services/fattura.service';
import { Router } from '@angular/router';
import { Fattura } from '../../../models/Fattura';
import { Fornitore } from '../../../models/Fornitore';
import { Dossier } from '../../../models/Dossier';

@Component({
    selector: 'app-fattura-insert',
    templateUrl: './fattura-insert.component.html',
    styleUrls: ['./fattura-insert.component.css']
})
export class FatturaInsertComponent implements OnInit {
    public insertFattura: Fattura;

    constructor(private fatturaService: FatturaService, private router: Router) { }

    ngOnInit() {
        this.insertFattura = new Fattura(0, null, null, null, 0, 0, null, null);
    }
    fatturaInsert(f: NgForm) {
        const fornitore: Fornitore = JSON.parse(sessionStorage.getItem('fornitore'));
        const dossier: Dossier = JSON.parse(sessionStorage.getItem('dossier'));
        this.insertFattura.fornitore = fornitore;
        this.insertFattura.dossier = dossier;
        this.fatturaService.insertFattura(this.insertFattura);
    }

}
