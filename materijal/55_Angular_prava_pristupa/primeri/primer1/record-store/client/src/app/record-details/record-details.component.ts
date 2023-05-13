import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
// import { Response, RequestOptions, 
//          Headers, URLSearchParams } from '@angular/http';
import { Record } from '../common.models';
import { RecordService } from '../main/record.service';

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

  constructor(private recordService: RecordService, private route: ActivatedRoute) { }

  ngOnInit() {
  	 this.sub = this.route.params.subscribe(params => {
      this.isDataAvailable = false;
      this.recordService.getRecord(params['id']).subscribe(
        (res:Record) => {
          this.record = res;
          this.isDataAvailable = true;
        }
      );
    });
  }

}
