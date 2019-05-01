import { Component, OnInit } from '@angular/core';
import { FatturaService } from '../../../services/fattura.service';
import { Fattura } from '../../../models/Fattura';
import { Router } from '@angular/router';

@Component({
    selector: 'app-fattura-management',
    templateUrl: './fattura-management.component.html',
    styleUrls: ['./fattura-management.component.css']
})
export class FatturaManagementComponent implements OnInit {
    public fatturaList: Array<Fattura>;

    constructor(private fatturaService: FatturaService, private router: Router) { }

    ngOnInit() {
        this.fatturaService.fatturaList().subscribe((response) => {
            this.fatturaList = response;
            console.log('La grandezza e\'' + this.fatturaList.length);
        });
    }

    removeLink(fatturaId: number) {
        this.fatturaService.deleteFattura(fatturaId);

    }

    updateLink(fatturaId: number) {
        this.router.navigateByUrl('/Fattura/update/' + fatturaId);
    }

    insertLink() {
        this.router.navigateByUrl('/Fattura/insert');
    }

}