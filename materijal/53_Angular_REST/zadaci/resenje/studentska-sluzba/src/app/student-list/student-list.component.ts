import {
  Component,
  OnInit,
  ViewEncapsulation,
  Input,
  Output,
  EventEmitter
} from '@angular/core';
import { Student, StudentInterface } from '../model/student.model';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class StudentListComponent implements OnInit {

  @Input()
  public students: Student[];

  @Output()
  studentDeleted: EventEmitter<number> = new EventEmitter();

  @Output()
  markStudentForEditing: EventEmitter<Student> = new EventEmitter();

  @Output()
  showStudentDetails: EventEmitter<Student> = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  deleteStudent(id: number) {
    this.studentDeleted.next(id);
  }

  editStudent(student: Student) {
    this.markStudentForEditing.next(student);
  }

  showStudentInfo(student: Student) {
    this.showStudentDetails.next(student);
  }

}
