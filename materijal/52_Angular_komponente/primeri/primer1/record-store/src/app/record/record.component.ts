import { Component, Input, Output, EventEmitter } from '@angular/core';

import { Record } from '../record.model';


@Component({
  selector: 'app-record',
  templateUrl: './record.component.html',
  styleUrls: ['./record.component.css']
})
export class RecordComponent {

  @Input()
  record:Record;
  
  @Input()
  index:number;
  
  @Output()
  deleteRecordIndex: EventEmitter<number>;

  @Output()
  showDetails: EventEmitter<Record> = new EventEmitter();

  constructor() { 
    this.deleteRecordIndex = new EventEmitter();
  }

  deleteRecord(index:number){
  	this.deleteRecordIndex.next(index);
  }
}
