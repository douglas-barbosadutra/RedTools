import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { MomService } from '../../../services/mom.service';
import { Mom } from '../../../models/Mom';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-mom-update',
  templateUrl: './mom-update.component.html',
  styleUrls: ['./mom-update.component.css']
})
export class MomUpdateComponent implements OnInit {

    idMom: number;
    public updateMom: Mom;

    // tslint:disable-next-line:max-line-length
    constructor(private momService: MomService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        /** Convert String to number */
        this.idMom = Number(this.route.snapshot.paramMap.get('idMom'));
        console.log('Mom id in update:' + this.idMom);
        this.momService.readMom(this.idMom).subscribe((response) => {
            this.updateMom = response;
            console.log('Mom caricato: ' + this.updateMom.aziendaCliente.denominazioneSocieta);
        });
    }

    update(f: NgForm) {
        console.log('Mom id: ' + f.value.idMom + ' ' + f.value.datadataDelGiornoMom);
        this.momService.updateMom(this.updateMom);

    }
}
