import { Component } from '@angular/core';
import { Item } from './item.model';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  private items: Item[];

  constructor(private http: HttpClient) {
    this.loadItems();
  }

  loadItems() {
    this.http.get('/api/auctionItems')
      .subscribe((data: Item[]) => {
        this.items = data;
      });
  }

  deleteItem(item: Item) {
    this.http.delete(`/api/auctionItems/${item.id}`)
      .subscribe(() => {
        this.loadItems();
      });
  }
}
