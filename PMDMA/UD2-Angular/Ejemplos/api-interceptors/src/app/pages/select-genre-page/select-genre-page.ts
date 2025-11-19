import { Component, OnInit } from '@angular/core';
import { Genre } from '../../interfaces/genre-list-response';
import { GenreService } from '../../services/genre-service';
import { Movie } from '../../interfaces/movie-list-response';
import { MoviesService } from '../../services/movies-service';

@Component({
  selector: 'app-select-genre-page',
  imports: [],
  templateUrl: './select-genre-page.html',
  styleUrl: './select-genre-page.css',
})
export class SelectGenrePage implements OnInit {

  genreList: Genre[] = []
  movieList: Movie[] = []

  constructor(private genreService: GenreService, private movieService:MoviesService) {}

  ngOnInit(): void {
    this.obtenerGeneros()
    this.obtenerPelis()
  }

  selectGenre(genre: Genre) {
    const titleElement = document.getElementById("titleGenre");
    if (titleElement) {
      titleElement.innerHTML = "Mostrando peliculas de: " + genre.name;
    }
    this.obtenerPelis(String(genre.id))
  }

  obtenerGeneros() {
    this.genreService.getGeneros().subscribe(r => {
      this.genreList = this.genreList.concat(r.genres)
    })
  }

  obtenerPelis(genreId: String = "", page = 1) {

    if (page == 1) {
      this.movieList = [];
    }

    if (genreId == "") {
      this.movieService.getMovies().subscribe( r =>
        this.movieList = this.movieList.concat(r.results)  
      )
    } else  {
      this.movieService.getMoviesByGenre(genreId).subscribe( r =>
        this.movieList = this.movieList.concat(r.results)  
      )
    }
  }



}
