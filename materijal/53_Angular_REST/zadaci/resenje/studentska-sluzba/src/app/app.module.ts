import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component';
import { StudentListItemComponent } from './student-list-item/student-list-item.component';
import { AddStudentFormComponent } from './form/add-student-form/add-student-form.component';
import { EditStudentFormComponent } from './form/edit-student-form/edit-student-form.component';
import { SearchComponent } from './search/search.component';
import { FilterComponent } from './filter/filter.component';
import { AddExamFormComponent } from './form/add-exam-form/add-exam-form.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    StudentListItemComponent,
    AddStudentFormComponent,
    EditStudentFormComponent,
    SearchComponent,
    FilterComponent,
    AddExamFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
