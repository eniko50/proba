import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentPassedExamsComponent } from './student-passed-exams.component';

describe('StudentPassedExamsComponent', () => {
  let component: StudentPassedExamsComponent;
  let fixture: ComponentFixture<StudentPassedExamsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentPassedExamsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentPassedExamsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
