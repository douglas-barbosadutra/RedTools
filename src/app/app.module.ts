import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';

/** Home component */
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
import { PercentualeOreReDManagementComponent } from './components/percentuale-ore-red/percentuale-ore-red-management/percentuale-ore-red-management.component';
import { PercentualeOreReDInsertComponent } from './components/percentuale-ore-red/percentuale-ore-red-insert/percentuale-ore-red-insert.component';
import { PercentualeOreReDUpdateComponent } from './components/percentuale-ore-red/percentuale-ore-red-update/percentuale-ore-red-update.component';

/** Services */
import { LoginService } from './services/login.service';
import { UserService } from './services/user.service';
import { AziendaClienteService } from './services/aziendaCliente.service';
import { ProgettoService } from './services/progetto.service';
import { DossierService } from './services/dossier.service';
import { MomService } from './services/mom.service';
import { FornitoreService } from './services/fornitore.service';
import { ImpiegatoService } from './services/impiegato.service';
import { FatturaService } from './services/fattura.service';
import { PercentualeOreReDService } from './services/percentualeOreReD.service';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserManagementComponent,
    UserInsertComponent,
    UserUpdateComponent,
    AziendaClienteManagementComponent,
    AziendaClienteInsertComponent,
    AziendaClienteUpdateComponent,
    ProgettoManagementComponent,
    ProgettoInsertComponent,
    ProgettoUpdateComponent,
    DossierManagementComponent,
    DossierInsertComponent,
    DossierUpdateComponent,
    MomManagementComponent,
    MomInsertComponent,
    MomUpdateComponent,
    FornitoreManagementComponent,
    FornitoreInsertComponent,
    FornitoreUpdateComponent,
    ImpiegatoManagementComponent,
    ImpiegatoInsertComponent,
    ImpiegatoUpdateComponent,
    FatturaManagementComponent,
    FatturaInsertComponent,
    FatturaUpdateComponent,
    PercentualeOreReDManagementComponent,
    PercentualeOreReDInsertComponent,
    PercentualeOreReDUpdateComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [
      LoginService,
      UserService,
      AziendaClienteService,
      ProgettoService,
      DossierService,
      MomService,
      FornitoreService,
      ImpiegatoService,
      FatturaService,
      PercentualeOreReDService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
