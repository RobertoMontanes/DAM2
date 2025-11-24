import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { base_url } from './people-service';
import { MovieResponse } from '../interfaces/movie-response-interface';

@Injectable({
  providedIn: 'root',
})
export class MovieService {

  constructor(private http:HttpClient) {}

  getPopularMovies(page: number = 1): Observable<MovieResponse> {

    let finalUrl = `${base_url}/movie/popular?page=${page}`;

    return this.http.get<MovieResponse>(finalUrl)
  }

  
}
