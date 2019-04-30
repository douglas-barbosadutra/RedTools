import { Component, OnInit } from '@angular/core';
import { MomService } from '../../../services/mom.service';
import { Mom } from '../../../models/Mom';
import { Router } from '@angular/router';

@Component({
    selector: 'app-mom-management',
    templateUrl: './mom-management.component.html',
    styleUrls: ['./mom-management.component.css']
})
export class MomManagementComponent implements OnInit {
    public momList: Array<Mom>;
    public idBo: number;

    constructor(private momService: MomService, private router: Router) { }

    ngOnInit() {
        this.momService.momList().subscribe((response) => {
            this.momList = response;
            console.log('La grandezza e\'' + this.momList.length);
        });
    }

    removeLink(momId: number) {
        this.momService.deleteMom(momId);

    }

    updateLink(momId: number) {
        this.router.navigateByUrl('/Mom/update/' + momId);
    }

    insertLink() {
        this.router.navigateByUrl('/Mom/insert');
    }

}