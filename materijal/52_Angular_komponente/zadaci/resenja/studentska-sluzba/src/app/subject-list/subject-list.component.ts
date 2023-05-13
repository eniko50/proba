import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Subject } from '../model/subject.model';

@Component({
  selector: 'app-subject-list',
  templateUrl: './subject-list.component.html',
  styleUrls: ['./subject-list.component.css']
})
export class SubjectListComponent implements OnInit {

  @Input() subjects: Subject[];
  @Output() deleteSubjectByCode: EventEmitter<string> = new EventEmitter();
  @Output() showSubjectByCode: EventEmitter<Subject> = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  deleteSubject(code: string) {
    this.deleteSubjectByCode.next(code);
  }

  showSubject(subject: Subject) {
    this.showSubjectByCode.next(subject);
  }

}
