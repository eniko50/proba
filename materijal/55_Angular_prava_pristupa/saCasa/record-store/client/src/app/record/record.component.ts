import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

import { Record } from '../common.models';
import { AuthenticationService } from '../security/authentication.service';


@Component({
  selector: 'tr[app-record]',//tr[app-record] znaci da ce se koristiti kao <tr app-record>
  templateUrl: './record.component.html',
  styleUrls: ['./record.component.css']
})
export class RecordComponent implements OnInit {

	@Input() record:Record;
	@Input() index:number;
	@Output() deleteRecordIndex: EventEmitter<number> = new EventEmitter();  

  constructor(private router: Router,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
  }

  deleteRecord(id:number){
  	this.deleteRecordIndex.next(id);
  }

  details(id) {
    this.router.navigate(['/record',id]);
  }
  
  isAdmin(): boolean {
    return this.authenticationService.isAdmin();
  }
}
