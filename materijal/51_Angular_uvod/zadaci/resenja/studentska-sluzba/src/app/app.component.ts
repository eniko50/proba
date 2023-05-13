import { Component } from '@angular/core';
import { Student} from './model/student.model';
import { Subject } from './model/subject.model';
import { Exam } from './model/exam.model';
import _ from 'lodash';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public students: Student[];
  public studentsClone: Student[];

  public subjects: Subject[];
  public subjectsClone: Subject[];
  
  public newStudent: Student;
  public newSubject: Subject;
  public newExam: Exam;

  public studentToEdit: Student;
  public subjectToEdit: Subject;
  public examToEdit: Exam;

  public activeStudent: Student;
  public activeSubject: Subject;

  public gradeGraterThan: number;
  public searchStudentNumber: string;
  public searchSubjectId: string;

  public order = OrderType;

  constructor() {
    this.initStudents();
    this.initSubjects();
    this.initNewData();
    this.initActiveData();
    this.initEditData();
    this.gradeGraterThan = 0;
    this.searchSubjectId = '';
    this.searchStudentNumber = '';
  }

  initStudents() {
    this.students = [];

    let student = new Student({
      studentNumber: 'e100',
      name: 'Zika',
      surname: 'Zikic'
    });

    this.students.push(student);

    student = new Student({
      studentNumber: 'e101',
      name: 'Mika',
      surname: 'Mikic'
    });

    this.students.push(student);

    student = new Student({
      studentNumber: 'e102',
      name: 'Pera',
      surname: 'Peric'
    });

    this.students.push(student);
    this.studentsClone = clone(this.students);
  }

  initSubjects() {
    this.subjects = [];

    let subject = new Subject({
      id: 'p100',
      title: 'Osnove programiranja',
      espbPoints: 9
    });

    this.subjects.push(subject);

    subject = new Subject({
      id: 'p101',
      title: 'Algoritmi i strukture podataka',
      espbPoints: 9
    });

    this.subjects.push(subject);

    subject = new Subject({
      id: 'p102',
      title: 'Web programiranje',
      espbPoints: 8
    });

    this.subjects.push(subject);
    this.subjectsClone = clone(this.subjects);
  }

  initNewData() {
    this.newStudent = emptyStudent();
    this.newSubject = emptySubject();
    this.newExam = emptyExam();
  }

  initActiveData() {
    this.activeStudent = emptyStudent();
    this.activeSubject = emptySubject();
  }

  initEditData() {
    this.studentToEdit = emptyStudent();
    this.subjectToEdit = emptySubject();
    this.examToEdit = emptyExam();
  }

  addStudent() {
    this.students.push(this.newStudent);
    this.studentsClone = clone(this.students);
    this.resetNewStudent();
  }

  addSubject() {
    this.subjects.push(this.newSubject);
    this.subjectsClone = clone(this.subjects);
    this.resetNewSubject();
  }

  addExam() {
    let subject = this.subjects.find(s => this.newExam.subject.id === s.id);
    this.newExam.subject = subject;
    this.activeStudent.passedExams.push(this.newExam);
    this.resetNewExam();
  }

  deleteStudent(index: number) {
    this.students.splice(index, 1);
    this.studentsClone = clone(this.students);
  }

  deleteSubject(index: number) {
    this.subjects.splice(index, 1);
    this.subjectsClone = clone(this.subjects);
  }

  deleteExam(index: number) {
    this.activeStudent.passedExams.splice(index, 1);
  }

  editStudent() {
    let i = this.students.findIndex(s => s.studentNumber === this.studentToEdit.studentNumber);
    this.students[i] = this.studentToEdit;
    this.studentsClone = clone(this.students);
  }

  editSubject() {
    let i = this.subjects.findIndex(s => s.id === this.subjectToEdit.id);
    this.subjects[i] = this.subjectToEdit;
    this.subjectsClone = clone(this.subjects);
  }

  editExam() {
    let i = this.activeStudent.passedExams.findIndex(e => e.subject.id === this.examToEdit.subject.id);
    this.activeStudent.passedExams[i] = this.examToEdit;
  }

  viewExams(index: number) {
    this.activeStudent = this.students[index];
  }

  resetNewStudent() {
    this.newStudent = emptyStudent();
  }

  resetNewSubject() {
    this.newSubject = emptySubject();
  }

  resetNewExam() {
    this.newExam = emptyExam();
  }

  searchByGradeGraterThan() {
    this.studentsClone = this.students.filter(s => s.averageGrade() >= this.gradeGraterThan);
  }

  searchByStudentNumber() {
    const student = this.students.find(s => s.studentNumber === this.searchStudentNumber);
    this.studentsClone = [student];
  }

  searchBySubjectId() {
    const subject = this.subjects.find(s => s.id === this.searchSubjectId);
    this.subjectsClone = [subject];
  }

  findBestStudent() {
    let avgGrades = this.students.map(s => s.averageGrade());
    let maxIdx = avgGrades.indexOf(Math.max(...avgGrades));
    this.studentsClone = [this.students[maxIdx]];
  }

  sortByAverageGrade(orderType: OrderType) {
    if (orderType === OrderType.ASC) {
      this.studentsClone = this.students.sort((s1, s2) => s1.averageGrade() - s2.averageGrade());
    } else {
      this.studentsClone = this.students.sort((s1, s2) => s2.averageGrade() - s1.averageGrade());
    }
  }

  findStudentsForNextYear() {
    this.studentsClone = this.students.filter(s => s.espbPoints() > 60);
  }

  resetStudentSearch() {
    this.studentsClone = this.students;
    this.gradeGraterThan = 0;
    this.searchStudentNumber = '';
  }

  resetSubjectSearch() {
    this.subjectsClone = this.subjects;
    this.searchSubjectId = '';
  }

  setStudentForEditing(index: number) {
    this.studentToEdit = clone(this.students[index]);
  }

  setSubjectForEditing(index: number) {
    this.subjectToEdit = clone(this.subjects[index]);
  }

  setExamForEditing(index: number) {
    this.examToEdit = clone(this.activeStudent.passedExams[index]);
  }

}

enum OrderType {
  ASC,
  DESC
}

const clone = (toClone) => _.cloneDeep(toClone);

const emptyStudent = () => {
  return new Student({
    studentNumber: '',
    name: '',
    surname: ''
  });
}

const emptySubject = () => {
  return new Subject({
    id: '',
    title: '',
    espbPoints: 0
  });
}

const emptyExam = () => {
  return new Exam({
    subject: new Subject({
      id: '',
      title: '',
      espbPoints: 0
    }),
    grade: 0
  });
}
