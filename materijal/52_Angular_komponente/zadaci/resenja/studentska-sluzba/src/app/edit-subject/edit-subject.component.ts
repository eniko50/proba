import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Subject } from '../model/subject.model';

@Component({
  selector: 'app-edit-subject',
  templateUrl: './edit-subject.component.html',
  styleUrls: ['./edit-subject.component.css']
})
export class EditSubjectComponent implements OnInit {

  @Input() subject: Subject;
  @Output() saveSubject: EventEmitter<Subject> = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  save() {
    if (!this.subject) {
      return;
    }

    this.saveSubject.next(this.subject);
  }
}
