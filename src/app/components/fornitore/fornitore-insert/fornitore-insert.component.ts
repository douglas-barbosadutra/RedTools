import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { FornitoreService } from '../../../services/fornitore.service';
import { Router } from '@angular/router';
import { Fornitore } from '../../../models/Fornitore';

@Component({
    selector: 'app-fornitore-insert',
    templateUrl: './fornitore-insert.component.html',
    styleUrls: ['./fornitore-insert.component.css']
})
export class FornitoreInsertComponent implements OnInit {
    public insertFornitore: Fornitore;

    public fornitoreTypes = [];
    constructor(private fornitoreService: FornitoreService, private router: Router) { }

    ngOnInit() {
        this.insertFornitore = new Fornitore(0, null, null, null, null);
    }
    fornitoreInsert(f: NgForm) {
        this.fornitoreService.insertFornitore(this.insertFornitore);
    }

}
