import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Subject } from '../model/subject.model';

@Component({
  selector: 'app-new-subject',
  templateUrl: './new-subject.component.html',
  styleUrls: ['./new-subject.component.css']
})
export class NewSubjectComponent implements OnInit {

  @Output() addSubject: EventEmitter<Subject> = new EventEmitter();

  subject: Subject;

  constructor() { }

  ngOnInit() {
    this.resetCurrentSubject();
  }

  resetCurrentSubject() {
    this.subject = new Subject({
      name: '',
      code: '',
      espb: 0
    });
  }

  addSubjectEvent() {
    this.addSubject.next(this.subject);
    this.resetCurrentSubject();
  }

}
