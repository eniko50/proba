import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Item } from '../item.model';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent {

  @Input()
  private item: Item;

  @Output()
  deleteItemEvent: EventEmitter<Item> = new EventEmitter();

  constructor() { }

  deleteItem() {
    this.deleteItemEvent.emit(this.item);
  }

}
