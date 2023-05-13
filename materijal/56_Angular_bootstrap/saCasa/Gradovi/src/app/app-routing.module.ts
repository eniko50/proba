import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CountryPageComponent } from './country-page/country-page.component';

const routes: Routes = [
  { path: '**', component: CountryPageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
