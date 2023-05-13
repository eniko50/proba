import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Student } from '../../model/student.model';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details-page.component.html',
  styleUrls: ['./student-details-page.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class StudentDetailsPageComponent implements OnInit {

  private id: number;
  private student: Student;

  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit() {
    this.resetStudent();
    this.loadData();
  }

  loadData() {
    this.route.params.subscribe(param => {
      this.id = +param['id'];
      this.http.get(`api/students/${this.id}`).subscribe(
        (res: any) => {
          this.student = res;
        }
      )
    })
  }

  resetStudent() {
    this.student = new Student({
      firstName: '',
      lastName: '',
      cardNumber: ''
    })
  }

}
