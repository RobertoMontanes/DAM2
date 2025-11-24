import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { baseURL } from './genres-service';
import { PeopleListResponse } from '../interfaces/people-list-response';
import { PeopleDetailsPage } from '../pages/people-details-page/people-details-page';
import { PeopleDetailsResponse } from '../interfaces/people-details-response';

@Injectable({
  providedIn: 'root',
})
export class PeopleService {
  
    constructor(private http:HttpClient) {}

    getPeople(page=1) {
      return this.http.get<PeopleListResponse>(`${baseURL}/person/popular?page=${page}`)
    }
    
    getPeopleDetails(id:number) {
      return this.http.get<PeopleDetailsResponse>(`${baseURL}/person/${id}`)
    }

}
