import { Subject } from './subject.model'

interface ExamInterface {
    subject: Subject;
    mark: number;
}

export class Exam implements ExamInterface {
    public subject: Subject;
    public mark: number;

    constructor(exam: ExamInterface) {
        this.subject = exam.subject;
        this.mark = exam.mark;
    }
}

export interface ExamDTO {
    exam: Exam;
    index: string;
}
