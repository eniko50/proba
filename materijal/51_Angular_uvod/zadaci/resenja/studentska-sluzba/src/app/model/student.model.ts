import { Exam } from './exam.model';

export class Student implements StudentInterface {
    public studentNumber: string;
    public name: string;
    public surname: string;
    public passedExams: Exam[];

    constructor(studentCfg: StudentInterface) {
        this.studentNumber = studentCfg.studentNumber;
        this.name = studentCfg.name;
        this.surname = studentCfg.surname;
        this.passedExams = studentCfg.passedExams || [];
    }

    public averageGrade(): number {
        if (!this.passedExams.length) {
            return 0;
        }
        const sum = this.passedExams.reduce((accum, exam) => accum + exam.grade, 0);
        return sum / this.passedExams.length;
    }

    public espbPoints(): number {
        return this.passedExams.reduce((accum, exam) => accum + exam.subject.espbPoints, 0);
    }
}

interface StudentInterface {
    studentNumber: string;
    name: string;
    surname: string;
    passedExams?: Exam[];
}