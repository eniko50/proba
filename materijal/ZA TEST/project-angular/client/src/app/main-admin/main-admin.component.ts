import { Component, OnInit } from '@angular/core';
import {Project, Comment} from '../common.models'
import {ProjectService} from '../main/project.service'
import { HttpClient, HttpParams } from '@angular/common/http'; 
import { Router } from '@angular/router'; 

@Component({
  selector: 'app-main-admin',
  templateUrl: './main-admin.component.html',
  styleUrls: ['./main-admin.component.css']
})
export class MainAdminComponent implements OnInit {


  page: any;
  pageNumber : number;
  projects : Project[];
  projectName : string;
  id: number;
  newProject: Project;
  project1: Project;
  

  constructor(private projectService:ProjectService, private http: HttpClient, private router:Router) {
    this.getPage(0);
   
    this.pageNumber = 0;

    this.newProject = new Project ({
      id : 0,
      name : "",
      description: "",
      readme: ""
       
    })
   }


  ngOnInit() { }

  getPage(pageNumber: number){
    let params = new HttpParams();
    if(this.projectName !== undefined){
      params = params.set('name', this.projectName);
     }
     this.http.get(`/api/projects?size=4&page=${pageNumber}`, {params})
    .subscribe(page => {
        this.page = page;
      } );
  }

setProjectName(){
  this.projectName;
  this.getPage(0);
}

resetFilter(){
  this.projectName = undefined;
  this.getPage(0);

}

previousPage() {
  this.getPage(this.page.number - 1);
}

nextPage() {
  this.getPage(this.page.number + 1);
}

delete(id:number){
 
  this.http.delete(`api/delete/${id}`).subscribe(() => {
    this.getPage(0);

  })
}


setProjectToUpdate(id:number){
    
  this.projectService.getProject(id).subscribe((res:Project) => {
   this.project1 = res;
   this.newProject.id = this.project1.id;
   this.newProject.name = this.project1.name;
   this.newProject.description = this.project1.description;
   this.newProject.readme = this.project1.readme;

    this.getPage(this.page.number);
  
 })
 

     
}


update(){
    if(this.newProject.id !== 0){
      this.projectService.putUpdate(this.newProject.id, this.newProject).subscribe((res:Project) => {
        this.newProject = res;
        this.getPage(0);
      })

    } else {
      this.projectService.saveProject(this.newProject).subscribe((res:Project) => {
        this.newProject = res;
        this.getPage(0);
      })
    }
 


}


resetEdit(){

  this.newProject.id = 0;
  this.newProject.name = "";
  this.newProject.description = "";
  this.newProject.readme = "";
  
}



}
