import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-item-page',
  templateUrl: './item-page.component.html',
  styleUrls: ['./item-page.component.css']
})
export class ItemPageComponent {
  private page: any = {
    size: 10,
    index: 0,
    content: [],
    last: false,
    first: true,
    totalElements: 198263
  }

  constructor(private http: HttpClient) {
    this.loadPage(0);
  }

  loadPage(pageNumber: number) {
    this.http.get(`/api/auctionItems?page=${pageNumber}&size=10`)
      .subscribe((page) => this.page = page);
  }

  loadPrevious() {
    this.loadPage(this.page.index - 1);
  }

  loadNext() {
    this.loadPage(this.page.index + 1);
  }
}
