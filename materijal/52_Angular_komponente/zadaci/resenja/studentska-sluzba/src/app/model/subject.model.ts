interface SubjectInterface {
    code: string;
    name: string;
    espb: number;
}

export class Subject implements SubjectInterface {
    public code: string;
    public name: string;
    public espb: number;

    constructor(subject: SubjectInterface) {
        this.code = subject.code;
        this.name = subject.name;
        this.espb = subject.espb;
    }
}