import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

/** Login */

import { LoginComponent } from './components/login/login.component';
/** Home */

import { HomeAdminComponent } from './components/home-admin/home-admin.component';
import { UserManagementComponent } from './components/user/user-management/user-management.component';
import { UserInsertComponent } from './components/user/user-insert/user-insert.component';
const routes: Routes = [

{ path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'homeAdmin', component: HomeAdminComponent },

/** User */
    { path: 'User/userManagement', component: UserManagementComponent },
    { path: 'User/insert', component: UserInsertComponent },

];
@NgModule({
    exports: [RouterModule],
    imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload', enableTracing: true })],
    declarations: []
})
export class AppRoutingModule { }
