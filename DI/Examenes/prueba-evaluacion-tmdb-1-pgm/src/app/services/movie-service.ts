import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { base_url } from './people-service';
import { MovieResponse } from '../interfaces/movie-list-response-interface';
import { MovieDetails } from '../interfaces/movie-details-response-interface';
import { VideoResponse } from '../interfaces/video-list-response';

@Injectable({
  providedIn: 'root',
})
export class MovieService {

  constructor(private http:HttpClient) {}

  getPopularMovies(page: number = 1): Observable<MovieResponse> {

    let finalUrl = `${base_url}/movie/popular?page=${page}`;

    return this.http.get<MovieResponse>(finalUrl)
  }
  
  getDetailMovies(id: number): Observable<MovieDetails> {
    let finalUrl = `${base_url}/movie/${id}`
    return this.http.get<MovieDetails>(finalUrl)
  }
  
  getMovieVideos(id: number): Observable<VideoResponse>  {
    let finalUrl = `${base_url}/movie/${id}/videos`
    return this.http.get<VideoResponse>(finalUrl)
  }

  
}
