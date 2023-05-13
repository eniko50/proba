import {
  Component,
  OnInit,
  ViewEncapsulation,
  Output,
  EventEmitter
} from '@angular/core';
import { Student } from '../../model/student.model';

@Component({
  selector: 'app-add-student-form',
  templateUrl: './add-student-form.component.html',
  styleUrls: ['./add-student-form.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AddStudentFormComponent implements OnInit {

  @Output()
  studentAdded: EventEmitter<Student> = new EventEmitter();

  private studentToAdd: Student;

  constructor() { }

  ngOnInit() {
    this.resetStudentToAdd();
  }

  addStudent() {
    this.studentAdded.next(this.studentToAdd);
    this.resetStudentToAdd();
  }

  resetStudentToAdd() {
    this.studentToAdd = new Student({
      firstName: '',
      lastName: '',
      cardNumber: ''
    })
  }

}
