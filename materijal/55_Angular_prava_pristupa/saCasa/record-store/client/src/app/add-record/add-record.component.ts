import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import { Record, AuthorInterface } from '../common.models';
import { AuthorServiceService } from '../author-service.service';

@Component({
  selector: 'app-add-record',
  templateUrl: './add-record.component.html',
  styleUrls: ['./add-record.component.css']
})
export class AddRecordComponent implements OnInit {

	@Output() newRecordAdded: EventEmitter<Record> = new EventEmitter();  

	public newRecord: Record;
  public authors: AuthorInterface[];

  constructor(private authorService: AuthorServiceService) {
    this.newRecord = new Record({
      title:'',
      author:{},
      imageUrl:'',
      styles:[],
      price:0
    });
  }

  ngOnInit() {
    this.loadData();    
  }

  loadData(){
    this.authorService.getAuthors()
      .subscribe((authors:AuthorInterface[]) => {
        this.authors = authors
      });
  }

  addRecord(){
  	this.newRecordAdded.next(this.newRecord);  	
    this.newRecord = new Record({
      title:'',
      author:{},
      imageUrl:'',
      styles:[],
      price:0
    });
  }

}
