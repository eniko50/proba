import { Component, OnInit } from '@angular/core';
import {Project, Comment} from '../common.models'
import {ProjectService} from '../main/project.service'
import { HttpClient, HttpParams } from '@angular/common/http'; 
import { Router, ActivatedRoute } from '@angular/router'; 


@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.css']
})
export class ProjectDetailsComponent implements OnInit {

  project:Project;
  id:number;
  sub:any;
  comments: Comment[];
  comment:Comment;
  newComment : Comment;


  constructor(private projectService:ProjectService, private http: HttpClient, private router:Router, private route: ActivatedRoute) { 
    this.getProject();
    this.newComment = new Comment ({
      username : "",
      text: "",
     

    })

  }

  getProject(){
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id'];
      this.projectService.getProject(this.id).subscribe((res: Project) => {
        this.project = res;
        
      })
    });
}



  ngOnInit() {
  }


  addComment(){
    
   this.projectService.postComment(this.id, this.newComment).subscribe((res:Comment) => {
      this.newComment = res;
      this.getProject();
       })

  }


}
