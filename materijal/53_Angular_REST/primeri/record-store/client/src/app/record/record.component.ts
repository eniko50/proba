import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

import { Record } from '../record.model';


@Component({
  selector: 'app-record',
  templateUrl: './record.component.html',
  styleUrls: ['./record.component.css']
})
export class RecordComponent implements OnInit {

	@Input() record:Record;
	@Input() index:number;
	@Output() deleteRecordIndex: EventEmitter<number> = new EventEmitter();  

  constructor() { }

  ngOnInit() {
  }

  deleteRecord(id:number){
  	this.deleteRecordIndex.next(id);
  }
}
