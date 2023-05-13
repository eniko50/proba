import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Exam } from '../../model/exam.model';
import { Subject } from '../../model/subject.model';

@Component({
  selector: 'app-exams-page',
  templateUrl: './exams-page.component.html',
  styleUrls: ['./exams-page.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ExamsPageComponent implements OnInit {

  private id: number;
  private exams: Exam[];
  private subjects: Subject[];
  private isDataFetched: boolean;

  constructor(private route: ActivatedRoute, private http: HttpClient) {
    this.isDataFetched = false;    
   }

  ngOnInit() {
    this.loadData();
  }

  filterNonPassedSubjects(allSubjects: Subject[]) {
    const passedSubjects = this.exams.map(e => e.course.id);
    this.subjects = allSubjects.filter(s => !passedSubjects.includes(s.id));
  }

  addExam(exam: Exam) {
    this.http.post(`api/students/${this.id}/exams`, exam).subscribe(
      (res: any) => {
        this.loadData();
      }
    )
  }

  loadData() {
    this.route.params.subscribe(param => {
      this.id = +param['id'];
      this.http.get(`api/students/${this.id}`).subscribe(
        (res: any) => {
          const student: any = res;
          this.exams = student.exams;

          this.http.get(`api/courses`).subscribe(
            (res: any) => {
              this.filterNonPassedSubjects(res);
              this.isDataFetched = true;
            }
          )
        }
      )
    });
  }

}