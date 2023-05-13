import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ProjectService} from './main/project.service'
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';
import { AuthenticationService } from './security/authentication.service';
import { CanActivateAuthGuard } from './security/can-activate-auth.guard';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptorService } from './security/token-interceptor.service';
import { JwtUtilsService } from './security/jwt-utils.service';
import { MainComponent } from './main/main.component';
import { ProjectDetailsComponent } from './project-details/project-details.component';
import { MainAdminComponent } from './main-admin/main-admin.component';
//dodaj Servise u providers, ako ih ima
@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    LoginComponent,
    MainComponent,
    ProjectDetailsComponent,
    MainAdminComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
     
      multi: true
    },
    AuthenticationService,
    CanActivateAuthGuard,
    ProjectService,
    JwtUtilsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
