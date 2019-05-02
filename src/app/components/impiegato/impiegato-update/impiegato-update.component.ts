import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ImpiegatoService } from '../../../services/impiegato.service';
import { Impiegato } from '../../../models/Impiegato';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-impiegato-update',
  templateUrl: './impiegato-update.component.html',
  styleUrls: ['./impiegato-update.component.css']
})
export class ImpiegatoUpdateComponent implements OnInit {

    idImpiegato: number;
    public updateImpiegato: Impiegato;

    public impiegatoTypes = [];

    // tslint:disable-next-line:max-line-length
    constructor(private impiegatoService: ImpiegatoService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        /** Convert String to number */
        this.idImpiegato = Number(this.route.snapshot.paramMap.get('idImpiegato'));
        console.log('Impiegato id in update:' + this.idImpiegato);
        this.impiegatoService.readImpiegato(this.idImpiegato).subscribe((response) => {
            this.updateImpiegato = response;
            console.log('Impiegato caricato: ' + this.updateImpiegato.nominativo);
        });
    }

    update(f: NgForm) {
        console.log('Impiegato id: ' + f.value.idImpiegato + ' ' + f.value.nominativo);
        this.impiegatoService.updateImpiegato(this.updateImpiegato);

    }
}
