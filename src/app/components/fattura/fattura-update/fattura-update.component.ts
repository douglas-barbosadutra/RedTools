import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FatturaService } from '../../../services/fattura.service';
import { Fattura } from '../../../models/Fattura';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-fattura-update',
  templateUrl: './fattura-update.component.html',
  styleUrls: ['./fattura-update.component.css']
})
export class FatturaUpdateComponent implements OnInit {

    idFattura: number;
    public updateFattura: Fattura;

    // tslint:disable-next-line:max-line-length
    constructor(private fatturaService: FatturaService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        /** Convert String to number */
        this.idFattura = Number(this.route.snapshot.paramMap.get('idFattura'));
        console.log('Fattura id in update:' + this.idFattura);
        this.fatturaService.readFattura(this.idFattura).subscribe((response) => {
            this.updateFattura = response;
            console.log('Fattura caricato: ' + this.updateFattura.numeroFattura);
        });
    }

    update(f: NgForm) {
        console.log('Fattura id: ' + f.value.idFattura + ' ' + f.value.numeroFattura);
        this.fatturaService.updateFattura(this.updateFattura);

    }
}
