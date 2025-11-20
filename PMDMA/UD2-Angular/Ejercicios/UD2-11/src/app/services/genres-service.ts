import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GenreListResponse } from '../interfaces/genre-list-response';

export const baseURL = "https://api.themoviedb.org/3";

@Injectable({
  providedIn: 'root',
})
export class GenresService {

  constructor(private http: HttpClient){}

  getGenres(genreKind:String = "movie") {
    return this.http.get<GenreListResponse>(`${baseURL}/genre/${genreKind}/list`)
  }
  
}
