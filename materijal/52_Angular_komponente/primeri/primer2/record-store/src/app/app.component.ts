import { Component } from '@angular/core';
import { Record } from './record.model';
import * as _ from 'lodash';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  public records: Record[];	  
  public newRecord: Record; 
  public orderTypes = Order;
  public priceFilter: PriceFilter;
  private recordsClone: Record[];

  constructor(){
    this.priceFilter = {
      lowest:0,
      heighest: 0
    }
    //ES6 metod kloniranja niza spread/rest operatorom i dekonstrukcijom
  	this.records = [];
    this.recordsClone = [...this.records];
    var record = new Record({
  		title:'Highway 61 Revisited',
  		imageUrl: 'https://upload.wikimedia.org/wikipedia/en/9/95/Bob_Dylan_-_Highway_61_Revisited.jpg',
		  styles: ['rock'],
		  author: 'Bob Dylan',
      price: 700
  	});
    this.records.push(record);
    record = new Record({
      title:'Birth of the Cool',
      imageUrl: 'https://upload.wikimedia.org/wikipedia/en/a/a8/Birth_of_the_Cool.jpg',
      styles: ['jazz','cool jazz'],
      author: 'Miles Davis',
      price: 950
    }); 
    this.records.push(record);
    record = new Record({
      title:'Five Tango Sensations',
      imageUrl: 'https://upload.wikimedia.org/wikipedia/en/0/0f/Kronos_tango.jpg',
      styles: ['classical', 'contemporary classical','tango nuevo'],
      author: 'Kronos quartet and Astor Piazzolla',
      price: 1200
    });
    this.records.push(record);
    record = new Record({
      title:'Interstellar Space',
      imageUrl: 'https://upload.wikimedia.org/wikipedia/en/2/26/John_Coltrane_Interstellar_Space.jpg',
      styles: [],
      author: 'John Coltrane',
      price: 550
    });
    this.records.push(record);
    this.recordsClone = [...this.records];
  }

  save(newRecord:Record){
    this.records.push(newRecord);
  }

  delete(index: number){
    this.records.splice(index,1);
  }

  sort(order:Order){
    this.records = this.recordsClone;
    if(order===Order.asc){
      this.records=_.sortBy(this.records, 'price');
    }
    else{
      this.records=_.sortBy(this.records, 'price').reverse();      
    }
  }

  filter(priceFilter: PriceFilter) {
    if (priceFilter) {
      this.filterRecords(priceFilter);
    } else {
      this.resetFilter();
    }
  }

  filterRecords(priceFilter: PriceFilter) {
    this.records = this.recordsClone.filter(record => 
      record.price > priceFilter.lowest && record.price < priceFilter.heighest
    );
  }

  resetFilter(){
    this.records = this.recordsClone;
  }
}

export enum Order{
  asc,
  desc
}

export interface PriceFilter{
  lowest: number;
  heighest: number;
}