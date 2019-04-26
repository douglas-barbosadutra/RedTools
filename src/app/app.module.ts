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

/** Services */
import { LoginService } from './services/login.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserManagementComponent,
    UserInsertComponent,
    UserUpdateComponent,
    AziendaClienteManagementComponent,
    AziendaClienteInsertComponent,
    AziendaClienteUpdateComponent
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
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
