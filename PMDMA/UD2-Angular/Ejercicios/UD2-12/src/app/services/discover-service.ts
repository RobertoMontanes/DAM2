import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { baseURL } from './genres-service';
import { TvDiscoverResponse } from '../interfaces/tv-discover-response';
import { Observable } from 'rxjs';
import { MovieDiscorverListResponse } from '../interfaces/movie-discover-response';

@Injectable({
  providedIn: 'root',
})
export class DiscoverService {
    constructor(private http: HttpClient){}

    getMovies(page: number = 1, genreID:String = "") {
      return this.http.get<MovieDiscorverListResponse>(`${baseURL}/discover/movie?page=${page}&&with_genres=${genreID}`)
    }
    
    getTvShow(page: number = 1, genreID:String = "") {
        return this.http.get<TvDiscoverResponse>(`${baseURL}/discover/tv?page=${page}&&with_genres=${genreID}`)
    }
}
