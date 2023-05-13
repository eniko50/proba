import { Subject } from './subject.model';

export class Exam implements ExamInterface {
    public subject: Subject;
    public grade: number;

    constructor(examCfg: ExamInterface) {
        this.subject = examCfg.subject;
        this.grade = examCfg.grade;
    }
}

interface ExamInterface {
    subject: Subject;
    grade: number;
}