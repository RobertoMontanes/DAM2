import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { baseURL } from './genres-service';
import { MovieListResponse } from '../interfaces/movie-list-response';
import { MovieDetailsResponse } from '../interfaces/movie-details-response';

@Injectable({
  providedIn: 'root',
})
export class MovieService {

  constructor(private http:HttpClient) {}

  getMovies(kind:String = "now_playing",page:number=1) {
    return this.http.get<MovieListResponse>(`${baseURL}/movie/${kind}?page=${page}`)
  }
  
  getMovieDetails(id:number) {
    return this.http.get<MovieDetailsResponse>(`${baseURL}/movie/${id}`)
  }
  
}
