import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

/** Login */

import { LoginComponent } from './components/login/login.component';
/** User */

import { UserManagementComponent } from './components/user/user-management/user-management.component';
import { UserInsertComponent } from './components/user/user-insert/user-insert.component';
import { UserUpdateComponent } from './components/user/user-update/user-update.component';

/** Azienda Cliente */
// tslint:disable-next-line:max-line-length
import { AziendaClienteManagementComponent } from './components/azienda-cliente/azienda-cliente-management/azienda-cliente-management.component';
import { AziendaClienteInsertComponent } from './components/azienda-cliente/azienda-cliente-insert/azienda-cliente-insert.component';
import { AziendaClienteUpdateComponent } from './components/azienda-cliente/azienda-cliente-update/azienda-cliente-update.component';
const routes: Routes = [

{ path: '', redirectTo: '/login', pathMatch: 'full' },
{ path: 'login', component: LoginComponent },

/** User */
{ path: 'User/userManagement', component: UserManagementComponent },
{ path: 'User/insert', component: UserInsertComponent },
{ path: 'User/update/:idUser', component: UserUpdateComponent },

/** Azienda Cliente */
{ path: 'AziendaCliente/aziendaClienteManagement', component: AziendaClienteManagementComponent },
{ path: 'AziendaCliente/insert', component: AziendaClienteInsertComponent },
{ path: 'AziendaCliente/update/:idUser', component: AziendaClienteUpdateComponent }

];
@NgModule({
    exports: [RouterModule],
    imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload', enableTracing: true })],
    declarations: []
})
export class AppRoutingModule { }
