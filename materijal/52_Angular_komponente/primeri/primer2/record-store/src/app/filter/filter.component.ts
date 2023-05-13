import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { PriceFilter } from '../app.component';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {
  priceFilter: PriceFilter;

  @Output()
  updateFilter: EventEmitter<PriceFilter> = new EventEmitter();
  
  constructor() { }

  ngOnInit() {
    this.priceFilter = { lowest: 0, heighest: 0 }
  }

  filterRecords() {
    this.updateFilter.next({
      lowest: this.priceFilter.lowest,
      heighest: this.priceFilter.heighest
    })
  }

  resetFilter() {
    this.updateFilter.next();
  }
}
