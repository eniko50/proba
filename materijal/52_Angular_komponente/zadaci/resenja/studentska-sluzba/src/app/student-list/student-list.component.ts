import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Student } from '../model/student.model';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  @Input() students: Student[]
  @Input() hasControls: boolean = true;
  @Output() deleteStudentByIndex: EventEmitter<string> = new EventEmitter();
  @Output() showStudentByIndex: EventEmitter<Student> = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  deleteStudent(index: string) {
    this.deleteStudentByIndex.next(index);
  }

  showStudent(student: Student) {
    this.showStudentByIndex.next(student);
  }

}
