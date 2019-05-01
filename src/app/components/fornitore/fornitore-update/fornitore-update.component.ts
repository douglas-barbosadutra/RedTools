import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FornitoreService } from '../../../services/fornitore.service';
import { Fornitore } from '../../../models/Fornitore';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-fornitore-update',
  templateUrl: './fornitore-update.component.html',
  styleUrls: ['./fornitore-update.component.css']
})
export class FornitoreUpdateComponent implements OnInit {

    idFornitore: number;
    public updateFornitore: Fornitore;

    // tslint:disable-next-line:max-line-length
    constructor(private fornitoreService: FornitoreService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        /** Convert String to number */
        this.idFornitore = Number(this.route.snapshot.paramMap.get('idFornitore'));
        console.log('Fornitore id in update:' + this.idFornitore);
        this.fornitoreService.readFornitore(this.idFornitore).subscribe((response) => {
            this.updateFornitore = response;
            console.log('Fornitore caricato: ' + this.updateFornitore.nomeFornitore);
        });
    }

    update(f: NgForm) {
        console.log('Fornitore id: ' + f.value.idFornitore + ' ' + f.value.nomeFornitore);
        this.fornitoreService.updateFornitore(this.updateFornitore);

    }
}
