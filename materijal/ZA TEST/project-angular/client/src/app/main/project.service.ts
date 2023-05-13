import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Project, Comment} from '../common.models'

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private http: HttpClient) { 
  }



  getProject(id:number): Observable<Project>{
    return this.http.get<Project>(`/api/projects/${id}`)
  }

  putUpdate(id:number, project:Project):  Observable<Project>{
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<Project>(`api/update/project/${id}`,JSON.stringify(project), {headers})
  }

  saveProject( project:Project):  Observable<Project>{ 
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<Project>(`api/create/project`,JSON.stringify(project), {headers})
  }

  postComment(id:number, comment: Comment): Observable<Comment>{
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<Comment>(`api/project/comment/${id}`,JSON.stringify(comment), {headers})
  }



}
