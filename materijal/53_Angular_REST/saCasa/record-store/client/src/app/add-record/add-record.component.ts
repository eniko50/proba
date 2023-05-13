import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Record, AuthorInterface } from '../record.model';
import { HttpClient, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-add-record',
  templateUrl: './add-record.component.html',
  styleUrls: ['./add-record.component.css']
})
export class AddRecordComponent implements OnInit {

  @Output() newRecordAdded: EventEmitter<Record> = new EventEmitter();

  public newRecord: Record;
  public JSON: Object;
  public authors: AuthorInterface[] = [];

  constructor(private http: HttpClient) {
    this.newRecord = new Record({
      title: '',
      author: {},
      imageUrl: '',
      styles: [],
      price: 0
    });
    this.JSON = JSON;
  }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.http.get('/api/authors').subscribe((res: AuthorInterface[]) => {
      this.authors = res;
    });
  }

  addRecord() {
    this.newRecordAdded.next(this.newRecord);
    this.newRecord = new Record({
      title: '',
      author: {},
      imageUrl: '',
      styles: [],
      price: 0
    });
  }
}
