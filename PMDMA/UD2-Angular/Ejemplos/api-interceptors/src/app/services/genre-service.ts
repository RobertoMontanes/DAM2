import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GenreListResponse } from '../interfaces/genre-list-response';

@Injectable({
  providedIn: 'root',
})
export class GenreService {

  constructor(private http:HttpClient) {}

  baseURL = "https://api.themoviedb.org/3";

  getGeneros() {
    return this.http.get<GenreListResponse>(`${this.baseURL}/genre/movie/list`)
  }

  
}
