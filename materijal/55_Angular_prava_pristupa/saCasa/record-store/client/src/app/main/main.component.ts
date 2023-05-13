import { Component, OnInit } from '@angular/core';
import { Record, AuthorInterface, Order } from '../common.models';

import * as _ from 'lodash';

import { PriceLimits } from '../filter-records/filter-records.component';

import { RecordService } from '../main/record.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  public records: Record[];	  
  public newRecord: Record; 
  public orderTypes = Order;
  public priceFilter: PriceLimits;
  public authors: AuthorInterface[];

  constructor(private recordService: RecordService) {
    recordService.getRecords();
    this.priceFilter = {
      lowest:0,
      highest: 0
    }
  	this.records = [];
    this.loadData();

  }

  ngOnInit() {
  }

  private loadData(order?: Order){
    this.recordService.
      getRecords(order,this.priceFilter.lowest,this.priceFilter.highest).
        subscribe((records: Record[]) => {this.records = records;});
  }

  save(newRecord:Record){
    this.recordService.saveRecord(newRecord).subscribe(
      () => {
        this.loadData();
      }
    );
  }

  delete(id: number){
    this.recordService.deleteRecord(id.toString()).subscribe(
      () => {
        this.loadData();
      }
    );
  }

  filterRecords(priceLimits: PriceLimits){
    this.priceFilter = priceLimits;
    this.loadData();
  }

  resetFilter(){
    this.priceFilter = {lowest:0,highest:0};
  }

}

