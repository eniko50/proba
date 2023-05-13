import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import { Record } from '../record.model';

@Component({
  selector: 'app-add-record',
  templateUrl: './add-record.component.html',
  styleUrls: ['./add-record.component.css']
})
export class AddRecordComponent implements OnInit {

  @Output()
  newRecordAdded: EventEmitter<Record> = new EventEmitter();
  
  ngOnInit() {
    
  }

	public newRecord: Record;

  constructor() {
    this.newRecord = {
      title:'',
      author:'',
      imageUrl:'',
      styles:[],
      price:0
    };
  }

  addRecord(){
	  this.newRecordAdded.next(this.newRecord);  	
    this.newRecord = {
      title:'',
      author:'',
      imageUrl:'',
      styles:[],
      price:0
    };
  }

}
