import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-filter-records',
  templateUrl: './filter-records.component.html',
  styleUrls: ['./filter-records.component.css']
})
export class FilterRecordsComponent implements OnInit {

	@Output() setPriceLimits: EventEmitter<PriceLimits> = new EventEmitter();
	public priceLimits: PriceLimits;

  constructor() {
  	this.priceLimits = {
  		lowest: 0,
  		heighest: 0
  	}
  }

  ngOnInit() {
  }

  filterRecords(){
  	this.setPriceLimits.next(this.priceLimits);
  }

  resetFilter(){
  	this.setPriceLimits.next({
  		lowest:0,
  		heighest:10000
  	});
  }

}

export interface PriceLimits{
	lowest: number;
	heighest: number;
}
