import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Student, StudentInterface } from '../../model/student.model';
import { Order } from '../../model/order.model';
import { AuthenticationService } from '../../service/authentication-service.service';

@Component({
  selector: 'app-students-page',
  templateUrl: './students-page.component.html',
  styleUrls: ['./students-page.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class StudentsPageComponent implements OnInit {

  public students: StudentInterface[];

  public activeStudent: StudentInterface;

  public isAdministrator: boolean;

  constructor(private http: HttpClient, private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.isAdministrator = this.authenticationService.getCurrentUser().roles.indexOf('ADMINISTRATOR') !== -1;

    this.resetActiveStudent();
    this.loadData();
  }

  loadData() {
    this.http.get('api/students').subscribe(
      (res: any) => {
        this.students = res;
      }
    );
  }

  addStudent(student: Student) {
    this.http.post('api/students', student).subscribe(
      (res: Response) => {
        this.loadData();
      }
    )
  }


  deleteStudent(id: number) {
    this.http.delete(`api/students/${id}`).subscribe(
      (res: Response) => {
        this.loadData();
      }
    )
  }

  editStudent(student) {
    this.http.put(`api/students/${student.id}`, student).subscribe(
      (res: any) => {
        this.resetActiveStudent();
        this.loadData();
      }
    )
  }

  setActiveStudent(student: Student) {
    this.activeStudent = new Student(student);
  }

  search(cardNumber: string) {
    this.http.get(`api/students?cardNumber=${cardNumber}`).subscribe(
      (res: any) => {
        this.students = res;
      }
    )
  }

  resetActiveStudent() {
    this.activeStudent = new Student({
      cardNumber: '',
      firstName: '',
      lastName: '',
    })
  }

  filterByAvgGrade(grade: number) {
    this.http.get(`api/students?averageGreaterThan=${grade}`).subscribe(
      (res: any) => {
        this.students = res;
      }
    )
  }

  filterByMaxGrade() {
    this.http.get(`api/students/maxAverage`).subscribe(
      (res: any) => {
        this.students = res;
      }
    )
  }

  filterByNextYearCondition() {
    this.http.get(`api/students/forNextYear`).subscribe(
      (res: any) => {
        this.students = res;
      }
    )
  }

  sortByGrade(order: Order) {
    this.http.get(`api/students?sortBy=${order}`).subscribe(
      (res: any) => {
        this.students = res;
      }
    )
  }

}
