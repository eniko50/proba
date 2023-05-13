export interface ProjectInterface {
    id? : number;
    name ?: string;
    description ?:  string;
    readme ?:  string;
    comments ?: CommentInterface[];
   }


    export class Project implements ProjectInterface{
        id? : number;
        name ?: string;
        description ?:  string;
       readme ?:  string;
       comments ?: CommentInterface[];
constructor(n: ProjectInterface){
    this.id = n.id,
    this. name = n.name,
    this.description =  n.description;
    this.readme =  n.readme;
    this.comments = n.comments;
   
}
    }


export interface CommentInterface {
    id? : number;
    username ?: string;
    text ?:  string; 
    projectId ?: number;
   }


   export class Comment implements CommentInterface{
    id ?:number;
    username ?: string;
    text ?: string;
    projectId ?: number;

    constructor(com: CommentInterface){

    this.id = com.id;
    this.username = com.username;
    this.text = com.text;
    this.projectId = com.projectId;
}
}


