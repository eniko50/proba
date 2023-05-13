import { Component, OnInit } from '@angular/core';
import {Project, Comment} from '../common.models'
import {ProjectService} from './project.service'
import { HttpClient, HttpParams } from '@angular/common/http'; 
import { Router } from '@angular/router'; 


@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  page: any;
  pageNumber : number;
  projects : Project[];
  comments : Comment[];
  projectName : string;


  constructor(private projectService:ProjectService, private http: HttpClient, private router:Router) {
    this.getPage(0);
   
    this.pageNumber = 0;



   }

  ngOnInit() {
  }


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




}
