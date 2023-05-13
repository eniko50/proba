export class Subject implements SubejctInterface {
    public id: string;
    public title: string;
    public espbPoints: number;

    constructor(subjectCfg: SubejctInterface) {
        this.id = subjectCfg.id;
        this.title = subjectCfg.title;
        this.espbPoints = subjectCfg.espbPoints;
    }
}

interface SubejctInterface {
    id: string;
    title: string;
    espbPoints: number;
}