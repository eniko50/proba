import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Record } from '../common.models';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-record-details',
  templateUrl: './record-details.component.html',
  styleUrls: ['./record-details.component.css']
})
export class RecordDetailsComponent implements OnInit {

  id: number;

  private sub: any;

  record: Record;

  isDataAvailable: boolean;

  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.isDataAvailable = false;
      this.id = +params['id']; // (+) konvertuje string 'id' u broj
      //id postavljamo kao path parametar pomocu interpolacije stringa
      this.http.get(`/api/records/${this.id}`).subscribe(
        //koristimo arrow funkciju da bismo imali leksicki
        //opseg this objekata
        (res: Record) => {
          this.record = res;
          this.isDataAvailable = true;
        },
        (error) => {
          if (error.status === 401) {
            
          }
        }
      );
    });
  }

}
