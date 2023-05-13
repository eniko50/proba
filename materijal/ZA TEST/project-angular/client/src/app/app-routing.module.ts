import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CanActivateAuthGuard } from './security/can-activate-auth.guard';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import {MainComponent} from './main/main.component'
import {ProjectDetailsComponent} from './project-details/project-details.component'
import {MainAdminComponent} from './main-admin/main-admin.component'


const routes: Routes = [
  { path: 'details/:id', component: ProjectDetailsComponent },
  { path: 'mainAdmin', component: MainAdminComponent, canActivate:[CanActivateAuthGuard]}, 
  { path: 'main', component: MainComponent},  
  { path: 'login', component: LoginComponent},  
  { path: '', redirectTo: 'main', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
