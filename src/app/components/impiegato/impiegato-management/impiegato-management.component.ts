import { Component, OnInit } from '@angular/core';
import { ImpiegatoService } from '../../../services/impiegato.service';
import { Impiegato } from '../../../models/Impiegato';
import { Router } from '@angular/router';

@Component({
    selector: 'app-impiegato-management',
    templateUrl: './impiegato-management.component.html',
    styleUrls: ['./impiegato-management.component.css']
})
export class ImpiegatoManagementComponent implements OnInit {
    public impiegatoList: Array<Impiegato>;


    constructor(private impiegatoService: ImpiegatoService, private router: Router) { }

    ngOnInit() {
        this.impiegatoService.impiegatoList().subscribe((response) => {
            this.impiegatoList = response;
            console.log('La grandezza e\'' + this.impiegatoList.length);
        });
    }

    removeLink(impiegatoId: number) {
        this.impiegatoService.deleteImpiegato(impiegatoId);

    }

    updateLink(impiegatoId: number) {
        this.router.navigateByUrl('/Impiegato/update/' + impiegatoId);
    }

    insertLink() {
        this.router.navigateByUrl('/Impiegato/insert');
    }

    percentualeOreReDLink(impiegato: Impiegato) {
        sessionStorage.setItem('impiegato', JSON.stringify(impiegato));
        this.router.navigateByUrl('/PercentualeOreReD/percentualeOreReDManagement');
    }

}
