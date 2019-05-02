import { Component, OnInit } from '@angular/core';
import { DossierService } from '../../../services/dossier.service';
import { Dossier } from '../../../models/Dossier';
import { Router } from '@angular/router';

@Component({
    selector: 'app-dossier-management',
    templateUrl: './dossier-management.component.html',
    styleUrls: ['./dossier-management.component.css']
})
export class DossierManagementComponent implements OnInit {
    public dossierList: Array<Dossier>;
    public campi = 6;


    constructor(private dossierService: DossierService, private router: Router) { }

    ngOnInit() {
        this.dossierService.dossierList().subscribe((response) => {
            this.dossierList = response;
            console.log('La grandezza e\'' + this.dossierList.length);
        });
    }

    removeLink(dossierId: number) {
        this.dossierService.deleteDossier(dossierId);

    }

    updateLink(dossierId: number) {
        this.router.navigateByUrl('/dossier/update/' + dossierId);
    }

    insertLink() {
        this.router.navigateByUrl('/dossier/insert');
    }

    fornitoreLink(dossier: Dossier) {
        sessionStorage.setItem('dossier', JSON.stringify(dossier));
        this.router.navigateByUrl('/Fornitore/fornitoreManagement');
    }

    impiegatoLink(dossier: Dossier) {
        sessionStorage.setItem('dossier', JSON.stringify(dossier));
        this.router.navigateByUrl('/Impiegato/impiegatoManagement');
    }

}
