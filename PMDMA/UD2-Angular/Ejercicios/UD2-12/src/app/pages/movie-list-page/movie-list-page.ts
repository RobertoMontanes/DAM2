import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../services/movie-service';
import { Movie, MovieListResponse } from '../../interfaces/movie-list-response';
import { DatePipe, SlicePipe } from '@angular/common';
import { NavbarComponent } from "../../components/navbar-component/navbar-component";

@Component({
  selector: 'app-movie-list-page',
  imports: [SlicePipe, DatePipe, NavbarComponent],
  templateUrl: './movie-list-page.html',
  styleUrl: './movie-list-page.css',
})
export class MovieListPage implements OnInit {


  movieList: Movie[] = []
  actualKind:String = "now_playing"
  actualPage = 1;

  constructor(private movieService: MovieService) {}

  kinds: String[] = [
    "now_playing",
    "popular",
    "top_rated",
    "upcoming"
  ]

  ngOnInit(): void {
    this.obtenerPeliculas()
  }

  obtenerPeliculas() {
    if (this.actualPage == 1) {
      this.movieService.getMovies(this.actualKind, this.actualPage).subscribe(r => {
        this.movieList = r.results
      })
    } else {
      this.movieService.getMovies(this.actualKind, this.actualPage).subscribe(r => {
        this.movieList = this.movieList.concat(r.results)
      })
      
    }
  }

  changeKind(kind: String) {
    this.actualKind = kind;
    this.actualPage = 1;
    this.obtenerPeliculas()
  } 

  nextPage() {
    this.actualPage = this.actualPage + 1
    this.obtenerPeliculas()
  }

  verDetalles(id:number) {
    window.location.href = `/movies/${id}`
  }

}
