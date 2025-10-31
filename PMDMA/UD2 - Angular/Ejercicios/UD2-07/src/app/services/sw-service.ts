import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StarWarsPeopleListResponse } from '../interfaces/StarWarsPeopleList-response-interface';

@Injectable({
  providedIn: 'root',
})
export class SwService {

  constructor(private http:HttpClient) {}

  getSWPeople(): Observable<StarWarsPeopleListResponse> {
    return this.http.get<StarWarsPeopleListResponse>('https://swapi.dev/api/people');
  }
  
}
