import { Component } from '@angular/core';
import { Record, AuthorInterface } from './record.model';

import * as _ from 'lodash';

import { PriceLimits } from './filter-records/filter-records.component';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  public records: Record[];	  
  public newRecord: Record; 
  public orderTypes = Order;
  public priceFilter: PriceLimits;
  public authors: AuthorInterface[];

  constructor(private http: HttpClient){
    this.priceFilter = {
      lowest:0,
      highest: 0
    }
  	this.records = [];
    this.loadData();
  }

  private loadData(order?: Order){
    let params: HttpParams = new HttpParams()
      .set('lowestPrice', this.priceFilter.lowest.toString())
      .set('highestPrice', this.priceFilter.highest.toString());
    if(order !== undefined){
      params = params.set('ord', order.toString());
    }
    this.http.get('/api/records', { params })
      // .subscribe(function (res: Record[]) {
      //   this.records=res;
      // });
      .subscribe((res: Record[]) => {
          this.records=res;
      });
  }

  save(newRecord:Record){
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    
    this.http.post('/api/records',JSON.stringify(newRecord), { headers }).subscribe(
      (res: any) => {
        this.loadData();
      }
    );
  }

  delete(id: number){
    this.http.delete('/api/records/'+id).subscribe(
      (res:any) => {
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

export enum Order{
  asc,
  desc
}
