import { Component, OnInit } from '@angular/core';
import { PercentualeOreReDService } from '../../../services/percentualeOreReD.service';
import { PercentualeOreReD } from '../../../models/PercentualeOreReD';
import { Router } from '@angular/router';

@Component({
    selector: 'app-percentuale-ore-red-management',
    templateUrl: './percentuale-ore-red-management.component.html',
    styleUrls: ['./percentuale-ore-red-management.component.css']
})
export class PercentualeOreReDManagementComponent implements OnInit {
    public percentualeOreReD: PercentualeOreReD;
    public idBo: number;
    public campi = 12;


    constructor(private percentualeOreReDService: PercentualeOreReDService, private router: Router) { }

    ngOnInit() {
        this.percentualeOreReDService.percentualeOreReD().subscribe((response) => {
            this.percentualeOreReD = response;
            console.log('La grandezza e\'' + this.percentualeOreReD);
        });
    }

    removeLink(percentualeOreReDId: number) {
        this.percentualeOreReDService.deletePercentualeOreReD(percentualeOreReDId);

    }

    updateLink(percentualeOreReDId: number) {
        this.router.navigateByUrl('/PercentualeOreReD/update/' + percentualeOreReDId);
    }

    insertLink() {
        this.router.navigateByUrl('/PercentualeOreReD/insert');
    }

}