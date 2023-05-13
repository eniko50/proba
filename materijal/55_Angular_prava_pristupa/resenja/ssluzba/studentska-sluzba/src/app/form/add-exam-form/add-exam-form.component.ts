import {
  Component,
  OnInit,
  ViewEncapsulation,
  EventEmitter,
  Output,
  Input
} from '@angular/core';
import { Exam } from '../../model/exam.model';
import { Subject } from '../../model/subject.model';

@Component({
  selector: 'app-add-exam-form',
  templateUrl: './add-exam-form.component.html',
  styleUrls: ['./add-exam-form.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AddExamFormComponent implements OnInit {

  @Output()
  examAdded: EventEmitter<Exam> = new EventEmitter();

  @Input()
  isDataFetched: boolean;

  @Input()
  subjects: Subject[];

  examToAdd: Exam;

  constructor() { }

  ngOnInit() {
    this.resetExamToAdd();
  }

  addExam(){
    this.examAdded.next(this.examToAdd);
  }

  resetExamToAdd() {
    this.examToAdd = new Exam({
      grade: 0,
      course: new Subject({
        code: '',
        name: '',
        espb: 0
      })
    })
  }

}
