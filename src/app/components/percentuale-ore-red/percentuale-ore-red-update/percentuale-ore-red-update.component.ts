import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { PercentualeOreReDService } from '../../../services/percentualeOreReD.service';
import { PercentualeOreReD } from '../../../models/PercentualeOreReD';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-percentuale-ore-red-update',
  templateUrl: './percentuale-ore-red-update.component.html',
  styleUrls: ['./percentuale-ore-red-update.component.css']
})
export class PercentualeOreReDUpdateComponent implements OnInit {

    idPercentualeOreReD: number;
    public updatePercentualeOreReD: PercentualeOreReD;

    public percentualeOreReDTypes = [];

    // tslint:disable-next-line:max-line-length
    constructor(private percentualeOreReDService: PercentualeOreReDService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        /** Convert String to number */
        this.idPercentualeOreReD = Number(this.route.snapshot.paramMap.get('idPercentualeOreReD'));
        console.log('PercentualeOreReD id in update:' + this.idPercentualeOreReD);
        this.percentualeOreReDService.readPercentualeOreReD(this.idPercentualeOreReD).subscribe((response) => {
            this.updatePercentualeOreReD = response;
            console.log('PercentualeOreReD caricato: ' + this.updatePercentualeOreReD.percentualeOreLavorateReD);
        });
    }

    update(f: NgForm) {
        console.log('PercentualeOreReD id: ' + f.value.idPercentualeOreReD + ' ' + f.value.percentualeOreLavorateReD);
        this.percentualeOreReDService.updatePercentualeOreReD(this.updatePercentualeOreReD);

    }
}
