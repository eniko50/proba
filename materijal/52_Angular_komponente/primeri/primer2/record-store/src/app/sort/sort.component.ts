import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Order } from '../app.component';

@Component({
  selector: 'app-sort',
  templateUrl: './sort.component.html',
  styleUrls: ['./sort.component.css']
})
export class SortComponent implements OnInit {

  @Output()
  sortEvent: EventEmitter<Order> = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  sortAscending() {
    this.sortEvent.next(Order.asc);
  }

  sortDescending() {
    this.sortEvent.next(Order.desc);
  }
}
