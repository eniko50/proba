import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Exam } from '../model/exam.model';

@Component({
  selector: 'app-edit-exam',
  templateUrl: './edit-exam.component.html',
  styleUrls: ['./edit-exam.component.css']
})
export class EditExamComponent implements OnInit {

  @Input() exam: Exam;
  @Output() saveExam: EventEmitter<Exam> = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  save() {
    if (!this.exam) {
      return;
    }

    this.saveExam.next(this.exam);
  }

}
