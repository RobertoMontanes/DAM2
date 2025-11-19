import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PopularMoviesRequest } from '../interfaces/popular-movies-request';

@Injectable({
  providedIn: 'root',
})
export class ApiService {

  API_URL = 'https://api.themoviedb.org/3'

  constructor(private http:HttpClient){}

  obtenerPeliculas(){
    return this.http.get<PopularMoviesRequest>(`${this.API_URL}/movie/popular`)
  }
  
}
