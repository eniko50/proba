import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Student } from '../model/student.model';

@Component({
  selector: 'app-new-student',
  templateUrl: './new-student.component.html',
  styleUrls: ['./new-student.component.css']
})
export class NewStudentComponent implements OnInit {

  @Output() addStudent: EventEmitter<Student> = new EventEmitter();

  currentStudent: Student;

  constructor() { }

  ngOnInit() {
    this.resetCurrentStudent();
  }

  resetCurrentStudent() {
    this.currentStudent = new Student({
      firstName: '',
      lastName: '',
      index: '',
      passedExams: []
    });
  }

  addStudentEvent() {
    this.addStudent.next(this.currentStudent);
    this.resetCurrentStudent();
  }

}
