import { Component, OnInit } from '@angular/core';
import { Record, AuthorInterface, Order } from '../common.models';


import * as _ from 'lodash';

import { PriceLimits } from '../filter-records/filter-records.component';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

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

  constructor(private http: HttpClient) {
    this.priceFilter = {
      lowest: 0,
      highest: 0
    }
    this.records = [];
    this.loadData();

  }

  ngOnInit() {
  }

  private loadData(order?: Order) {
    let params = new HttpParams();
    params = params.set('lowestPrice', this.priceFilter.lowest.toString());
    params = params.set('highestPrice', this.priceFilter.highest.toString());
    if (order !== undefined) {
      params = params.set('ord', order.toString());
    }
    
    this.http.get('/api/records', { params }).subscribe(
      //koristimo arrow funkciju da bismo imali leksicki
      //opseg this objekata
      (res: Record[]) => {
        this.records = res;
      }
    );
  }

  save(newRecord: Record) {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    this.http.post('/api/records', newRecord, { headers }).subscribe(
      (res: any) => {
        this.loadData();
      }
    );
  }

  delete(id: number) {
    this.http.delete('/api/records/' + id).subscribe(
      (res: any) => {
        this.loadData();
      }
    );
  }

  filterRecords(priceLimits: PriceLimits) {
    this.priceFilter = priceLimits;
    this.loadData();
  }

  resetFilter() {
    this.priceFilter = { lowest: 0, highest: 0 };
  }

}

