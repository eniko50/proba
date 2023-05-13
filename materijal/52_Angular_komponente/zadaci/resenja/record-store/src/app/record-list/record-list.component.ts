import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';

import { Record } from '../record.model';

@Component({
  selector: 'app-record-list',
  templateUrl: './record-list.component.html',
  styleUrls: ['./record-list.component.css']
})
export class RecordListComponent implements OnInit {
 
 @Input() records: Record[];
 @Output() deleteRecordIndex: EventEmitter<number> = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  delete(index:number){
  	this.deleteRecordIndex.next(index);
  }
}
