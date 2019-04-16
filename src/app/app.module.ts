import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';

/** Home component */
import { LoginComponent } from './components/login/login.component';
import { HomeAdminComponent } from './components/home-admin/home-admin.component';
/** User */
import { UserManagementComponent } from './components/user/user-management/user-management.component';
import { UserInsertComponent } from './components/user/user-insert/user-insert.component';
/** Services */
import { LoginService } from './services/login.service';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeAdminComponent,
     UserManagementComponent,
     UserInsertComponent,
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
