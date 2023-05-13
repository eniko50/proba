import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RecordDetailsComponent } from './record-details/record-details.component';
import { MainComponent } from './main/main.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
  { path: 'record/:id', component: RecordDetailsComponent },
  { path: 'main', component: MainComponent },  
  { path: '', redirectTo: 'main', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
