import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../../services/api-service';
import { Movie } from '../../../interfaces/popular-movies-request';

@Component({
  selector: 'app-popular-movies-page',
  imports: [],
  templateUrl: './popular-movies-page.html',
  styleUrl: './popular-movies-page.css',
})
export class PopularMoviesPage implements OnInit {

  movies:Movie[] = []

  constructor(private service: ApiService) {}

  ngOnInit(): void {
    this.service.obtenerPeliculas().subscribe(r => this.movies = this.movies.concat(r.results))
  }


}
