import { Component, OnInit } from '@angular/core';
import { FornitoreService } from '../../../services/fornitore.service';
import { Fornitore } from '../../../models/Fornitore';
import { Router } from '@angular/router';

@Component({
    selector: 'app-fornitore-management',
    templateUrl: './fornitore-management.component.html',
    styleUrls: ['./fornitore-management.component.css']
})
export class FornitoreManagementComponent implements OnInit {
    public fornitoreList: Array<Fornitore>;

    constructor(private fornitoreService: FornitoreService, private router: Router) { }

    ngOnInit() {
        this.fornitoreService.fornitoreList().subscribe((response) => {
            this.fornitoreList = response;
            console.log('La grandezza e\'' + this.fornitoreList.length);
        });
    }

    removeLink(fornitoreId: number) {
        this.fornitoreService.deleteFornitore(fornitoreId);

    }

    updateLink(fornitoreId: number) {
        this.router.navigateByUrl('/Fornitore/update/' + fornitoreId);
    }

    insertLink() {
        this.router.navigateByUrl('/Fornitore/insert');
    }

    fatturaLink(fornitore: Fornitore) {
        sessionStorage.setItem('fornitore', JSON.stringify(fornitore));
        this.router.navigateByUrl('/Fattura/fatturaManagement');
    }
}
