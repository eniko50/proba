import { Exam } from './exam.model';
import { Student } from './student.model';
import { Subject } from './subject.model';

export class StudentService {
    public students: Student[];
    public subjects: Subject[];

    constructor() {
        this.students = [];
        this.subjects = [];
    }

    public indexOfStudent(index: string): number {
        for (var i = 0; i < this.students.length; i++) {
            let student = this.students[i];
            if (student.index === index) {
                return i;
            }
        }

        return -1;
    }

    public indexOfSubject(code: string): number {
        for (var i = 0; i < this.subjects.length; i++) {
            var subject = this.subjects[i];
            if (subject.code === code) {
                return i;
            }
        }

        return -1;
    }

    public addStudent(student: Student) {
        this.students.push(student);
    }

    public addSubject(subject: Subject) {
        this.subjects.push(subject);
    }

    public addExam(index: string, exam: Exam) {
        let idx = this.indexOfStudent(index);
        if (idx !== -1) {
            this.students[idx].passedExams.push(exam);
        }
    }

    public findStudent(index: string): Student {
        let idx = this.indexOfStudent(index);
        if (idx !== -1) {
            return this.students[idx];
        }
    }

    public findSubject(code: string): Subject {
        let idx = this.indexOfSubject(code);
        if (idx !== -1) {
            return this.subjects[idx];
        }
    }

    public findExam(index: string, code: string): Exam {
        let student = this.findStudent(index);
        if (student) {
            return student.findExam(code);
        }
    }

    public deleteStudent(index: string) {
        let idx = this.indexOfStudent(index);
        if (idx !== -1) {
            this.students.splice(idx, 1);
        }
    }

    public deleteSubject(code: string) {
        let idx = this.indexOfSubject(code);
        if (idx !== -1) {
            this.subjects.splice(idx, 1);
        }

        this.students.forEach(student => {
            student.deleteExam(code);
        })
    }

    public deleteExam(index: string, code: string) {
        let student = this.findStudent(index);
        if (student) {
            student.deleteExam(code);
        }
    }

    public updateStudent(updated: Student) {
        let student = this.findStudent(updated.index);
        if (student) {
            student.firstName = updated.firstName;
            student.lastName = updated.lastName;
        }
    }

    public updateSubject(updated: Subject) {
        let subject = this.findSubject(updated.code);
        if (subject) {
            subject.name = updated.name;
            subject.espb = updated.espb;
        }
    }

    public updateExam(index: string, updated: Exam) {
        let student = this.findStudent(index);
        if (student) {
            student.updateExam(updated);
        }
    }

    public studentWithAverageHigherThan(mark: number) {
        return this.students.filter(student => student.averageMark() > mark);
    }

    public studentWithMaxAverage(): Student[] {
        if (!this.students.length) {
            return [];
        }

        var maxAverage = this.students[0].averageMark();

        this.students.forEach(student => {
            var average = student.averageMark();

            if (average > maxAverage) {
                maxAverage = average;
            }
        });

        return this.students.filter(student => student.averageMark() >= maxAverage);
    }

    public sortByAverageMark() {
        this.students.sort((a, b) => a.averageMark() - b.averageMark());
    }

    public studentsForNewYear(): Student[] {
        return this.students.filter(student => student.pointTotal() >= 60);
    }

}