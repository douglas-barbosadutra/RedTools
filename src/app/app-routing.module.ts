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

/** Progetto */
import { ProgettoManagementComponent } from './components/progetto/progetto-management/progetto-management.component';
import { ProgettoInsertComponent } from './components/progetto/progetto-insert/progetto-insert.component';
import { ProgettoUpdateComponent } from './components/progetto/progetto-update/progetto-update.component';

/** Dossier */
import { DossierManagementComponent } from './components/dossier/dossier-management/dossier-management.component';
import { DossierInsertComponent } from './components/dossier/dossier-insert/dossier-insert.component';
import { DossierUpdateComponent } from './components/dossier/dossier-update/dossier-update.component';

/** Mom */
import { MomManagementComponent } from './components/mom/mom-management/mom-management.component';
import { MomInsertComponent } from './components/mom/mom-insert/mom-insert.component';
import { MomUpdateComponent } from './components/mom/mom-update/mom-update.component';

/** Fornitore */
import { FornitoreManagementComponent } from './components/fornitore/fornitore-management/fornitore-management.component';
import { FornitoreInsertComponent } from './components/fornitore/fornitore-insert/fornitore-insert.component';
import { FornitoreUpdateComponent } from './components/fornitore/fornitore-update/fornitore-update.component';

/** Impiegato */
import { ImpiegatoManagementComponent } from './components/impiegato/impiegato-management/impiegato-management.component';
import { ImpiegatoInsertComponent } from './components/impiegato/impiegato-insert/impiegato-insert.component';
import { ImpiegatoUpdateComponent } from './components/impiegato/impiegato-update/impiegato-update.component';

/** Fattura */
import { FatturaManagementComponent } from './components/fattura/fattura-management/fattura-management.component';
import { FatturaInsertComponent } from './components/fattura/fattura-insert/fattura-insert.component';
import { FatturaUpdateComponent } from './components/fattura/fattura-update/fattura-update.component';

/** PercentualeOreReD */
// tslint:disable-next-line:max-line-length
import { PercentualeOreReDManagementComponent } from './components/percentuale-ore-red/percentuale-ore-red-management/percentuale-ore-red-management.component';
// tslint:disable-next-line:max-line-length
import { PercentualeOreReDInsertComponent } from './components/percentuale-ore-red/percentuale-ore-red-insert/percentuale-ore-red-insert.component';
// tslint:disable-next-line:max-line-length
import { PercentualeOreReDUpdateComponent } from './components/percentuale-ore-red/percentuale-ore-red-update/percentuale-ore-red-update.component';


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
{ path: 'AziendaCliente/update/:idAziendaCliente', component: AziendaClienteUpdateComponent },

/** Progetto */
{ path: 'Progetto/progettoManagement', component: ProgettoManagementComponent },
{ path: 'Progetto/insert', component: ProgettoInsertComponent },
{ path: 'Progetto/update/:idProgetto', component: ProgettoUpdateComponent },

/** Dossier */
{ path: 'Dossier/dossierManagement', component: DossierManagementComponent },
{ path: 'Dossier/insert', component: DossierInsertComponent },
{ path: 'Dossier/update/:idDossier', component: DossierUpdateComponent },

/** Mom */
{ path: 'Mom/momManagement', component: MomManagementComponent },
{ path: 'Mom/insert', component: MomInsertComponent },
{ path: 'Mom/update/:idMom', component: MomUpdateComponent },

/** Fornitore */
{ path: 'Fornitore/fornitoreManagement', component: FornitoreManagementComponent },
{ path: 'Fornitore/insert', component: FornitoreInsertComponent },
{ path: 'Fornitore/update/:idFornitore', component: FornitoreUpdateComponent },

/** Impiegato */
{ path: 'Impiegato/impiegatoManagement', component: ImpiegatoManagementComponent },
{ path: 'Impiegato/insert', component: ImpiegatoInsertComponent },
{ path: 'Impiegato/update/:idImpiegato', component: ImpiegatoUpdateComponent },

/** Fattura */
{ path: 'Fattura/fatturaManagement', component: FatturaManagementComponent },
{ path: 'Fattura/insert', component: FatturaInsertComponent },
{ path: 'Fattura/update/:idFattura', component: FatturaUpdateComponent },

/** PercentualeOreReD */
{ path: 'PercentualeOreReD/percentualeOreReDManagement', component: PercentualeOreReDManagementComponent },
{ path: 'PercentualeOreReD/insert', component: PercentualeOreReDInsertComponent },
{ path: 'PercentualeOreReD/update/:idPercentualeOreReD', component: PercentualeOreReDUpdateComponent }

];
@NgModule({
    exports: [RouterModule],
    imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload', enableTracing: true })],
    declarations: []
})
export class AppRoutingModule { }
