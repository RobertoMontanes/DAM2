import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { baseURL } from './genres-service';

@Injectable({
  providedIn: 'root',
})
export class PeopleService {
  
    constructor(private http:HttpClient) {}

    getPeople() {
      return this.http.get<>(`${baseURL}/person`)
    }

}
