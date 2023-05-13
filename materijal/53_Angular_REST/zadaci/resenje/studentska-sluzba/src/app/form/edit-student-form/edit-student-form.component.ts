import {
  Component,
  OnInit,
  ViewEncapsulation,
  Input,
  Output,
  EventEmitter
} from '@angular/core';
import { Student } from '../../model/student.model';


@Component({
  selector: 'app-edit-student-form',
  templateUrl: './edit-student-form.component.html',
  styleUrls: ['./edit-student-form.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class EditStudentFormComponent implements OnInit {

  @Output()
  studentEdited: EventEmitter<Student> = new EventEmitter();

  @Input()
  studentToEdit: Student;

  constructor() { }

  ngOnInit() {
  }

  editStudent() {
    this.studentEdited.next(this.studentToEdit);
  }

}
