import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PopularMoviesRequest } from '../interfaces/popular-movies-request';

@Injectable({
  providedIn: 'root',
})
export class ApiService {

  apiKey = '510cf67d07a0a046a32480eb9098b27b'
  apiToken = 'eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1MTBjZjY3ZDA3YTBhMDQ2YTMyNDgwZWI5MDk4YjI3YiIsIm5iZiI6MTc2MzM2NzQ4Mi4zMjQsInN1YiI6IjY5MWFkYTNhMDM5NGQ1YWQ0MjZkOTI1NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.uD8kgDmUK2TeT41R5r50ZpqdOlutm3-q4G4nAXz2naQ'
  headers = {
    'Authorization': `Bearer ${this.apiToken}`
  }
  API_URL = 'https://api.themoviedb.org/3'

  constructor(private http:HttpClient){}

  obtenerPeliculas(){
    return this.http.get<PopularMoviesRequest>(`${this.API_URL}/movie/popular`, {headers: this.headers})
  }
  
}
