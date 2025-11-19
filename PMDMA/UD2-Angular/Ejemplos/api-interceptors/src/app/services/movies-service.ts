import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MovieListResponse } from '../interfaces/movie-list-response';

@Injectable({
  providedIn: 'root',
})
export class MoviesService {


  constructor(private http:HttpClient) {}

  baseURL = "https://api.themoviedb.org/3";

    getMoviesByGenre(page: number,id: String) {
      return this.http.get<MovieListResponse>(`${this.baseURL}/discover/movie?page=${page}&&with_genres=${id}`)
    }
    
    getMovies(page: number,) {
      return this.http.get<MovieListResponse>(`${this.baseURL}/discover/movie?page=${page}`)
    }
  
}
