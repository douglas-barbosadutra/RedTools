import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../services/user.service';
import { User } from '../../../models/User';
import { Router } from '@angular/router';

@Component ({
    selector : 'app-user-update',
    templateUrl : './user-update.component.html',
    styleUrls : ['./user-update.component.css']
})


export class UserUpdateComponent{
    utenti = [
        {
        username :'nome 1',
        password :'pass1',
        tipo :'user'
        },{
        username :'nome 2',
        password :'pass 2',
        tipo :'user'
        }
    ];
}