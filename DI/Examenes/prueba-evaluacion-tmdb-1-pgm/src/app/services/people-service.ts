import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PeopleResponse } from '../interfaces/people-response-interface';


export const base_url = "https://api.themoviedb.org/3"

@Injectable({
  providedIn: 'root',
})
export class PeopleService {

  constructor(private http:HttpClient) {}

  getPopularPeople(page: number = 1): Observable<PeopleResponse> {

    let finalUrl = `${base_url}/person/popular?page=${page}`;

    return this.http.get<PeopleResponse>(finalUrl)
  }

}
