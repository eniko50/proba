import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { RecordComponent } from './record/record.component';
import { RecordListComponent } from './record-list/record-list.component';
import { AddRecordComponent } from './add-record/add-record.component';
import { FilterRecordsComponent } from './filter-records/filter-records.component';
import { SortRecordsComponent } from './sort-records/sort-records.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { MainComponent } from './main/main.component';
import { RecordDetailsComponent } from './record-details/record-details.component';
import { RecordService } from './main/record.service';
import { LoginComponent } from './login/login.component';
import { AuthenticationService } from './security/authentication.service';
import { CanActivateAuthGuard } from './security/can-activate-auth.guard';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptorService } from './security/token-interceptor.service';
import { JwtUtilsService } from './security/jwt-utils.service';
import { AuthorServiceService } from './author-service.service';


@NgModule({
  declarations: [
    AppComponent,
    RecordComponent,
    RecordListComponent,
    AddRecordComponent,
    FilterRecordsComponent,
    SortRecordsComponent,
    PageNotFoundComponent,
    MainComponent,
    RecordDetailsComponent,
    LoginComponent,
    AuthorServiceService
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
    RecordService, 
    AuthenticationService,
    CanActivateAuthGuard,
    JwtUtilsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
