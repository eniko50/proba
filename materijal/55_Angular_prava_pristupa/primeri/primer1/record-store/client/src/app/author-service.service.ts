import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthorInterface } from './common.models';

@Injectable({
  providedIn: 'root'
})
export class AuthorServiceService {

  constructor(private http: HttpClient) { }

  getAuthors(): Observable<AuthorInterface[]>{
    return this.http.get<AuthorInterface[]>('/api/authors');

  }   
}
