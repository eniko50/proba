import { Component, OnInit, Input } from '@angular/core';
import { Student } from '../model/student.model';
import { StudentService } from '../model/service.model';

@Component({
  selector: 'app-student-filter',
  templateUrl: './student-filter.component.html',
  styleUrls: ['./student-filter.component.css']
})
export class StudentFilterComponent implements OnInit {

  @Input() service: StudentService;

  selectedAverage: number;
  foundStudents: Student[];

  constructor() {
    this.selectedAverage = 0;
    this.foundStudents = [];
  }

  ngOnInit() {
  }

  showWithAverageHigherThan() {
    this.foundStudents = this.service.studentWithAverageHigherThan(this.selectedAverage);
  }

  showWithHighestAverage() {
    this.foundStudents = this.service.studentWithMaxAverage();
  }

  showForNextYear() {
    this.foundStudents = this.service.studentsForNewYear();
  }

}
