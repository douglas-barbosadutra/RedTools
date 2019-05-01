import { Component, OnInit } from '@angular/core';
import { ProgettoService } from '../../../services/progetto.service';
import { Progetto } from '../../../models/Progetto';
import { Router } from '@angular/router';


@Component({
    selector: 'app-progetto-management',
    templateUrl: './progetto-management.component.html',
    styleUrls: ['./progetto-management.component.css']
})
export class ProgettoManagementComponent implements OnInit {
    public progettoList: Array<Progetto>;


    constructor(private progettoService: ProgettoService, private router: Router) { }

    ngOnInit() {
        this.progettoService.progettoList().subscribe((response) => {
            this.progettoList = response;
            console.log('La grandezza e\'' + this.progettoList.length);
        });
    }

    removeLink(progettoId: number) {
        this.progettoService.deleteProgetto(progettoId);

    }

    updateLink(progettoId: number) {
        this.router.navigateByUrl('/Progetto/update/' + progettoId);
    }

    insertLink() {
        this.router.navigateByUrl('/Progetto/insert');
    }

}