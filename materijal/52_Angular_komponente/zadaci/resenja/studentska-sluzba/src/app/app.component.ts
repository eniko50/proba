import { Component, OnInit } from '@angular/core';
import { Student } from './model/student.model';
import { Exam, ExamDTO } from './model/exam.model';
import { Subject } from './model/subject.model';
import { StudentService } from './model/service.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';

  studentService: StudentService;
  shownStudent: Student;
  shownSubject: Subject;

  ngOnInit() {
    this.studentService = new StudentService();

    let student1 = new Student({
      firstName: 'Pera',
      lastName: 'Peric',
      index: '1',
      passedExams: []
    });
    this.studentService.addStudent(student1);
    let student2 = new Student({
      firstName: 'Mika',
      lastName: 'Mikic',
      index: '2',
      passedExams: []
    });
    this.studentService.addStudent(student2);
    let student3 = new Student({
      firstName: 'Steva',
      lastName: 'Oroz',
      index: '3',
      passedExams: []
    });
    this.studentService.addStudent(student3);
    let student4 = new Student({
      firstName: 'Sima',
      lastName: 'Simic',
      index: '4',
      passedExams: []
    });
    this.studentService.addStudent(student4);

    let subject1 = new Subject({
      code: '1',
      name: 'Web',
      espb: 6
    });
    this.studentService.addSubject(subject1);
    let subject2 = new Subject({
      code: '2',
      name: 'Analiza',
      espb: 9
    });
    this.studentService.addSubject(subject2);
    let subject3 = new Subject({
      code: '3',
      name: 'NTP',
      espb: 8
    });
    this.studentService.addSubject(subject3);

    let exam1 = new Exam({
      subject: subject1,
      mark: 8
    });
    this.studentService.addExam(student1.index, exam1);
    let exam2 = new Exam({
      subject: subject2,
      mark: 9
    });
    this.studentService.addExam(student1.index, exam2);
    let exam3 = new Exam({
      subject: subject3,
      mark: 10
    })
    this.studentService.addExam(student2.index, exam3);
  }

  showStudent(student: Student) {
    this.shownStudent = new Student(student);
  }

  showSubject(subject: Subject) {
    this.shownSubject = new Subject(subject);
  }

  addExam(dto: ExamDTO) {
    this.studentService.addExam(dto.index, dto.exam);
  }

  updateExam(dto: ExamDTO) {
    this.studentService.updateExam(dto.index, dto.exam);
  }

  deleteExam(dto: ExamDTO) {
    this.studentService.deleteExam(dto.index, dto.exam.subject.code);
  }

}
