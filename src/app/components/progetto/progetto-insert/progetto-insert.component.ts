import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ProgettoService } from '../../../services/progetto.service';
import { Router } from '@angular/router';
import { Progetto } from '../../../models/Progetto';

@Component({
    selector: 'app-progetto-insert',
    templateUrl: './progetto-insert.component.html',
    styleUrls: ['./progetto-insert.component.css']
})
export class ProgettoInsertComponent implements OnInit {
    public insertProgetto: Progetto;

    public progettoTypes = [];
    constructor(private progettoService: ProgettoService, private router: Router) { }

    ngOnInit() {
        this.insertProgetto = new Progetto(0, null, null, null, null)
    }
    progettoInsert(f: NgForm) {
        this.progettoService.insertProgetto(this.insertProgetto);
    }

}