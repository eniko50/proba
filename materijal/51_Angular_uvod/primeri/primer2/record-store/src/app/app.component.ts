import { Component } from '@angular/core';
import { Record } from './record.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  public records: Record[];	  

  constructor(){
  	this.records = [];
    var record = new Record({
  		title:'Highway 61 Revisited',
  		imageUrl: 'https://upload.wikimedia.org/wikipedia/en/9/95/Bob_Dylan_-_Highway_61_Revisited.jpg',
		  styles: ['rock'],
		  author: 'Bob Dylan'
  	});
    this.records.push(record);
    record = new Record({
      title:'Birth of the Cool',
      imageUrl: 'https://upload.wikimedia.org/wikipedia/en/a/a8/Birth_of_the_Cool.jpg',
      styles: ['jazz','cool jazz'],
      author: 'Miles Davis'
    }); 
    this.records.push(record);
    record = new Record({
      title:'Five Tango Sensations',
      imageUrl: 'https://upload.wikimedia.org/wikipedia/en/0/0f/Kronos_tango.jpg',
      styles: ['classical', 'contemporary classical','tango nuevo'],
      author: 'Kronos quartet and Astor Piazzolla'
    });
    this.records.push(record);
    record = new Record({
      title:'Interstellar Space',
      imageUrl: 'https://upload.wikimedia.org/wikipedia/en/2/26/John_Coltrane_Interstellar_Space.jpg',
      styles: [],
      author: 'John Coltrane'
    });
    this.records.push(record);
  }
}
