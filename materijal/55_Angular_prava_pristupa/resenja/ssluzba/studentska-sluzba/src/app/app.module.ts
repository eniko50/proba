import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component';
import { StudentDetailsPageComponent } from './page/student-details-page/student-details-page.component';
import { StudentsPageComponent } from './page/students-page/students-page.component';
import { StudentListItemComponent } from './student-list-item/student-list-item.component';
import { ExamsPageComponent } from './page/exams-page/exams-page.component';
import { AddStudentFormComponent } from './form/add-student-form/add-student-form.component';
import { EditStudentFormComponent } from './form/edit-student-form/edit-student-form.component';
import { SearchComponent } from './search/search.component';
import { FilterComponent } from './filter/filter.component';
import { PageNotFoundComponent } from './page/page-not-found/page-not-found.component';
import { AddExamFormComponent } from './form/add-exam-form/add-exam-form.component';
import { LoginComponent } from './login/login.component';
import { TokenInterceptorService } from './service/token-interceptor.service';
import { AuthenticationService } from './service/authentication-service.service';
import { CanActivateAuthGuard } from './service/can-activate-auth.guard';
import { JwtUtilsService } from './service/jwt-utils.service';

@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    StudentDetailsPageComponent,
    StudentsPageComponent,
    StudentListItemComponent,
    ExamsPageComponent,
    AddStudentFormComponent,
    EditStudentFormComponent,
    SearchComponent,
    FilterComponent,
    PageNotFoundComponent,
    AddExamFormComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
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
    JwtUtilsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
