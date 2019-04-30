import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MomService } from '../../../services/mom.service';
import { Router } from '@angular/router';
import { Mom } from '../../../models/Mom';
import { AziendaCliente } from '../../../models/AziendaCliente';

@Component({
    selector: 'app-mom-insert',
    templateUrl: './mom-insert.component.html',
    styleUrls: ['./mom-insert.component.css']
})
export class MomInsertComponent implements OnInit {
    public insertMom: Mom;

    constructor(private momService: MomService, private router: Router) { }

    ngOnInit() {
        const aziendaCliente : AziendaCliente = JSON.parse(sessionStorage.getItem('aziendaCliente'));
        this.insertMom = new Mom(0, null, null, null, null, null, null, null, null, null, aziendaCliente);
    }
    momInsert(f: NgForm) {
        this.momService.insertMom(this.insertMom);
    }

}