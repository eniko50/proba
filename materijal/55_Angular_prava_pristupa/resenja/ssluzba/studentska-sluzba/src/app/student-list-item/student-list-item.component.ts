import {
  Component,
  OnInit,
  ViewEncapsulation,
  Input,
  Output,
  EventEmitter
} from '@angular/core';
import { Student } from '../model/student.model';

@Component({
  selector: 'app-student-list-item',
  templateUrl: './student-list-item.component.html',
  styleUrls: ['./student-list-item.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class StudentListItemComponent implements OnInit {

  @Input()
  student: Student;

  @Input()
  public isAdministrator: boolean;

  @Output()
  studentDeleted: EventEmitter<number> = new EventEmitter();

  @Output()
  markStudentForEditing: EventEmitter<Student> = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  deleteStudent() {
    this.studentDeleted.next(this.student.id);
  }

  editStudent() {
    this.markStudentForEditing.next(this.student);
  }

  isDeletingAllowed():boolean {
    return !this.student.exams.length;
  }

}
