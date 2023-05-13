import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { StudentsPageComponent } from './page/students-page/students-page.component';
import { CanActivateAuthGuard } from './service/can-activate-auth.guard';
import { StudentDetailsPageComponent } from './page/student-details-page/student-details-page.component';
import { ExamsPageComponent } from './page/exams-page/exams-page.component';
import { PageNotFoundComponent } from './page/page-not-found/page-not-found.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'studenti', component: StudentsPageComponent, canActivate: [CanActivateAuthGuard] },
  { path: 'studenti/:id', component: StudentDetailsPageComponent, canActivate: [CanActivateAuthGuard] },
  { path: 'studenti/:id/predmeti', component: ExamsPageComponent, canActivate: [CanActivateAuthGuard] },
  { path: '', redirectTo: 'studenti', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
