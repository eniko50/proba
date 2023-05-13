import { Component } from '@angular/core';
import { Record } from './record.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  public record: Record;	  

  constructor(){
  	this.record = new Record({
  		title:'Highway 61 Revisited',
  		imageUrl: 'https://upload.wikimedia.org/wikipedia/en/9/95/Bob_Dylan_-_Highway_61_Revisited.jpg',
		style: ['rock'],
		author: 'Bob Dylan'
  	});
  }
}
