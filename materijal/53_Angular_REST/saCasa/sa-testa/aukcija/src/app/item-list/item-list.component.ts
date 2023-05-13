import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Item } from '../item.model';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent {

  @Input()
  private items: Item[];

  @Output()
  deleteItemEvent: EventEmitter<Item> = new EventEmitter();

  constructor() { }

  deleteItem(item: Item) {
    this.deleteItemEvent.emit(item);
  }
}
