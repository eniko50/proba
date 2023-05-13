import { Component } from '@angular/core';
import { Student, StudentInterface } from './model/student.model';
import { Order } from './model/order.model';
import { Exam } from './model/exam.model';
import { Subject, SubjectInterface } from './model/subject.model';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  activeStudent: StudentInterface;
  shownStudent: Student;

  students: Student[];

  subjects: Subject[];
  availableSubjects: Subject[];
  isDataFetched: boolean;

  constructor(private http: HttpClient) {
    this.students = [];
  }

  ngOnInit() {
    this.resetActiveStudent();
    this.loadData();

    this.http.get(`api/courses`).subscribe(
      (res: SubjectInterface[]) => {
        this.subjects = res.map(subject => new Subject(subject));
        this.isDataFetched = true;
      }
    )
  }

  filterNonPassedSubjects() {
    const passedSubjects = this.activeStudent.exams.map(e => e.course.id);
    this.availableSubjects = this.subjects.filter(s => !passedSubjects.includes(s.id));
  }

  loadData() {
    this.http.get('api/students')
      .subscribe((res: StudentInterface[]) => this.loadStudentsFromResponse(res));
  }

  private loadStudentsFromResponse(students: StudentInterface[]) {
    this.students = students.map(s => new Student(s));
    console.log('Got students:');
    console.log(this.students);

    if (this.shownStudent) {
      this.shownStudent = this.students.filter(s => this.shownStudent.id === s.id)[0];
    }
  }

  addStudent(student: Student) {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    this.http.post('api/students', JSON.stringify(student), { headers }).subscribe(() => {
      this.loadData();
    });
  }

  deleteStudent(id: number) {
    this.http.delete(`api/students/${id}`).subscribe(
      (res: Response) => {
        this.loadData();
      }
    )
  }

  editStudent(student) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    this.http.put(`api/students/${student.id}`, JSON.stringify(student), { headers }).subscribe(() => {
      this.resetActiveStudent();
      this.loadData();
    });
  }

  setActiveStudent(student: Student) {
    this.activeStudent = new Student(student);
  }

  search(cardNumber: string) {
    const params = new HttpParams()
      .set('cardNumber', cardNumber);

    this.http.get(`api/students`, { params })
      .subscribe((res: StudentInterface[]) => this.loadStudentsFromResponse(res));
  }

  resetActiveStudent() {
    this.activeStudent = new Student({
      cardNumber: '',
      firstName: '',
      lastName: '',
    })
  }

  filterByAvgGrade(grade: number) {
    const params = new HttpParams()
      .set('averageGreaterThan', `${grade}`);
    
    this.http.get(`api/students`, { params })
      .subscribe((res: StudentInterface[]) => this.loadStudentsFromResponse(res));
  }

  filterByMaxGrade() {
    this.http.get(`api/students/maxAverage`)
      .subscribe((res: StudentInterface[]) => this.loadStudentsFromResponse(res));
  }

  filterByNextYearCondition() {
    this.http.get(`api/students/forNextYear`)
      .subscribe((res: StudentInterface[]) => this.loadStudentsFromResponse(res));
  }

  sortByGrade(order: Order) {
    const params = new HttpParams()
      .set('sortBy', `${order}`);
    
    this.http.get(`api/students`, { params })
      .subscribe((res: StudentInterface[]) => this.loadStudentsFromResponse(res));
  }

  addExam(exam: Exam) {
    if (!this.shownStudent) {
      return;
    }

    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    
    this.http.post(`api/students/${this.shownStudent.id}/exams`, JSON.stringify(exam), { headers }).subscribe(() => {
      this.loadData();
    });
  }

  showStudentInfo(student: Student) {
    this.shownStudent = student;
    this.filterNonPassedSubjects();
  }

}
