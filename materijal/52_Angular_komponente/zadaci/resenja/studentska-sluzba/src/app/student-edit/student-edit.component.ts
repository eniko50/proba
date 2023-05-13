import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Student } from '../model/student.model';
import { Subject } from '../model/subject.model';
import { Exam, ExamDTO } from '../model/exam.model';

@Component({
  selector: 'app-student-edit',
  templateUrl: './student-edit.component.html',
  styleUrls: ['./student-edit.component.css']
})
export class StudentEditComponent implements OnInit {

  @Input() student: Student;
  @Input() subjects: Subject[] = [];
  @Output() saveStudent: EventEmitter<Student> = new EventEmitter();
  @Output() saveExam: EventEmitter<ExamDTO> = new EventEmitter();
  @Output() deleteExam: EventEmitter<ExamDTO> = new EventEmitter();
  @Output() updateExam: EventEmitter<ExamDTO> = new EventEmitter();

  newExam: Exam;
  selectedExam: Exam;

  constructor() { }

  ngOnInit() {
    this.resetExam();
  }

  resetExam() {
    this.newExam = new Exam({
      mark: 0,
      subject: {
        code: "",
        name: "",
        espb: 0
      }
    });
  }

  save() {
    if (!this.student) {
      return;
    }

    this.saveStudent.next(this.student);
  }

  addExam() {
    if (!this.student) {
      return;
    }

    this.saveExam.next({
      exam: this.newExam,
      index: this.student.index
    });
    this.resetExam();
  }

  deleteExamClick(exam: Exam) {
    if (!this.student) {
      return;
    }

    this.deleteExam.next({
      exam: exam,
      index: this.student.index
    });
  }

  showExamClick(exam: Exam) {
    if (!this.student) {
      return;
    }

   this.selectedExam = new Exam(exam);
  }

  updateExamEvent(exam: Exam) {
    console.log(exam);
    if (!this.student) {
      return;
    }

    this.updateExam.next({
      exam: exam,
      index: this.student.index
    });
  }

}
