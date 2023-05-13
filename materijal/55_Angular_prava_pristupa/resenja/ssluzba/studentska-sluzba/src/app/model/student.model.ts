import { Exam } from './exam.model';

export interface StudentInterface {
    id?: number;
    firstName: string;
    lastName: string;
    cardNumber: string;
    exams?: Exam[];
}

export class Student implements StudentInterface {
    public id: number;
    public firstName: string;
    public lastName: string;
    public cardNumber: string;
    public exams: Exam[];

    constructor(studentCfg: StudentInterface) {
        this.id = studentCfg.id;
        this.firstName = studentCfg.firstName;
        this.lastName = studentCfg.lastName;
        this.cardNumber = studentCfg.cardNumber;
        this.exams = studentCfg.exams || [];
    }

    public indexOfExam(code: string): number {
        for (var i = 0; i < this.exams.length; i++) {
            var exam = this.exams[i];
            if (exam.course.code === code) {
                return i;
            }
        }

        return -1;
    }

    public findExam(code: string): Exam {
        let idx = this.indexOfExam(code);
        if (idx !== -1) {
            return this.exams[idx];
        }
    }

    public deleteExam(code: string): boolean {
        var idx = this.indexOfExam(code);
        var examFound = idx !== -1;
        if (examFound) {
            this.exams.splice(idx, 1);
        }

        return examFound;
    }

    public updateExam(updated: Exam) {
        let exam = this.findExam(updated.course.code);
        if (exam) {
            exam.grade = updated.grade;
        }
    }

    public averageGrade(): number {
        if (!this.exams.length) {
            return 0;
        }

        var sum = 0;

        this.exams.forEach(exam => {
            sum += exam.grade;
        });

        return sum / this.exams.length;
    }

    public pointTotal(): number {
        return this.exams.reduce((total, exam) => total + exam.course.espb, 0);
    }
}