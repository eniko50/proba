import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { RecordComponent } from './record/record.component';
import { RecordListComponent } from './record-list/record-list.component';
import { AddRecordComponent } from './add-record/add-record.component';
import { FilterRecordsComponent } from './filter-records/filter-records.component';
import { SortRecordsComponent } from './sort-records/sort-records.component';

@NgModule({
  declarations: [
    AppComponent,
    RecordComponent,
    RecordListComponent,
    AddRecordComponent,
    FilterRecordsComponent,
    SortRecordsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
