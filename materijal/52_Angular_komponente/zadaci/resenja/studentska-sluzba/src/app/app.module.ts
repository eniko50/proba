import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NewStudentComponent } from './new-student/new-student.component';
import { StudentListComponent } from './student-list/student-list.component';
import { StudentEditComponent } from './student-edit/student-edit.component';
import { SubjectListComponent } from './subject-list/subject-list.component';
import { NewSubjectComponent } from './new-subject/new-subject.component';
import { EditSubjectComponent } from './edit-subject/edit-subject.component';
import { EditExamComponent } from './edit-exam/edit-exam.component';
import { StudentFilterComponent } from './student-filter/student-filter.component';

@NgModule({
  declarations: [
    AppComponent,
    NewStudentComponent,
    StudentListComponent,
    StudentEditComponent,
    SubjectListComponent,
    NewSubjectComponent,
    EditSubjectComponent,
    EditExamComponent,
    StudentFilterComponent
  ],
  imports: [
    FormsModule,
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
