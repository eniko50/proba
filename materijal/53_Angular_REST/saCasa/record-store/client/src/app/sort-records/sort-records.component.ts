import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import { Order } from '../app.component';

@Component({
  selector: 'app-sort-records',
  templateUrl: './sort-records.component.html',
  styleUrls: ['./sort-records.component.css']
})
export class SortRecordsComponent implements OnInit {

	@Output() setRecordOrder: EventEmitter<Order> = new EventEmitter();

	public orderTypes = Order;

  constructor() { 
  }

  ngOnInit() {
  }

  sort(recordOrder: Order){
   	this.setRecordOrder.next(recordOrder);
  }

}
