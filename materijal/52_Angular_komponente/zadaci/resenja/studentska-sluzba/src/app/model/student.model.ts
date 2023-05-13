import { Exam } from './exam.model';

interface StudentInterface {
    firstName: string;
    lastName: string;
    index: string;
    passedExams: Exam[];
}

export class Student implements StudentInterface {
    public firstName: string;
    public lastName: string;
    public index: string;
    public passedExams: Exam[];

    constructor(student: StudentInterface) {
        this.firstName = student.firstName;
        this.lastName = student.lastName;
        this.index = student.index;
        this.passedExams = student.passedExams || [];
    }

    public indexOfExam(code: string): number {
        for (var i = 0; i < this.passedExams.length; i++) {
            var exam = this.passedExams[i];
            if (exam.subject.code === code) {
                return i;
            }
        }

        return -1;
    }

    public findExam(code: string): Exam {
        let idx = this.indexOfExam(code);
        if (idx !== -1) {
            return this.passedExams[idx];
        }
    }

    public deleteExam(code: string): boolean {
        var idx = this.indexOfExam(code);
        var examFound = idx !== -1;
        if (examFound) {
            this.passedExams.splice(idx, 1);
        }

        return examFound;
    }

    public updateExam(updated: Exam) {
        let exam = this.findExam(updated.subject.code);
        if (exam) {
            exam.mark = updated.mark;
        }
    }

    public averageMark(): number {
        if (!this.passedExams.length) {
            return 0;
        }

        var sum = 0;

        this.passedExams.forEach(exam => {
            sum += exam.mark;
        });

        return sum / this.passedExams.length;
    }

    public pointTotal(): number {
        return this.passedExams.reduce((total, exam) => total + exam.subject.espb, 0);
    }
}