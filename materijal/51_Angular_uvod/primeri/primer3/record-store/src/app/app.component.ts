import { Component } from '@angular/core';
import { Record } from './record.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  public records: Record[];
  public displayRecords: Record[];
  public newRecord: Record;
  public query = {
    title: '',
    author: '',
    applyPriceFilter: false,
    lowPrice: 0,
    highPrice: 0
  };

  constructor() {
    this.records = [];
    this.newRecord = {
      title: '',
      author: '',
      imageUrl: '',
      styles: [],
      price: 0
    };
    var record = new Record({
      title: 'Highway 61 Revisited',
      imageUrl: 'https://upload.wikimedia.org/wikipedia/en/9/95/Bob_Dylan_-_Highway_61_Revisited.jpg',
      styles: ['rock'],
      author: 'Bob Dylan',
      price: 1023
    });
    this.records.push(record);
    record = new Record({
      title: 'Birth of the Cool',
      imageUrl: 'https://upload.wikimedia.org/wikipedia/en/a/a8/Birth_of_the_Cool.jpg',
      styles: ['jazz', 'cool jazz'],
      author: 'Miles Davis',
      price: 19283
    });
    this.records.push(record);
    record = new Record({
      title: 'Five Tango Sensations',
      imageUrl: 'https://upload.wikimedia.org/wikipedia/en/0/0f/Kronos_tango.jpg',
      styles: ['classical', 'contemporary classical', 'tango nuevo'],
      author: 'Kronos quartet and Astor Piazzolla',
      price: 91862
    });
    this.records.push(record);
    record = new Record({
      title: 'Interstellar Space',
      imageUrl: 'https://upload.wikimedia.org/wikipedia/en/2/26/John_Coltrane_Interstellar_Space.jpg',
      styles: [],
      author: 'John Coltrane',
      price: 197
    });
    this.records.push(record);
    this.displayRecords = this.records;
  }

  filter() {
    this.displayRecords = this.records
      .filter(record => record.title.includes(this.query.title))
      .filter(record => record.author.includes(this.query.author))
      .filter(record => {
        if (!this.query.applyPriceFilter) {
          return true;
        }

        return this.query.lowPrice <= record.price && this.query.highPrice >= record.price;
      });
  }

  save() {
    if (this.newRecord.price <= 0) {
      alert('Cena ne sme biti manja od 0.')
      return;
    }

    var newRecordCopy: Record = new Record(this.newRecord);
    this.records.push(newRecordCopy);

    this.newRecord = {
      title: '',
      author: '',
      imageUrl: '',
      styles: [],
      price: 0
    };
  }

  delete(index: number) {
    this.records.splice(index, 1);
  }
}
