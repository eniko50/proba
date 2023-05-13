import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-country-page',
  templateUrl: './country-page.component.html',
  styleUrls: ['./country-page.component.css']
})
export class CountryPageComponent implements OnInit {

  private page: any;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getPage(0);
  }

  getPage(pageNumber: number) {
    this.http.get(`/api/countries?size=5&page=${pageNumber}`)
      .subscribe(page => {
        this.page = page;
      });
  }

}
